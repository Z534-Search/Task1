package com.search.core;


import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.search.core.objectStructure.Business;
import it.cnr.jatecs.classification.ClassificationScoreDB;
import it.cnr.jatecs.classification.ClassifierRangeWithScore;
import it.cnr.jatecs.classification.interfaces.IClassifier;
import it.cnr.jatecs.classification.module.Classifier;
import it.cnr.jatecs.classification.naivebayes.NaiveBayesLearner;
import it.cnr.jatecs.classification.naivebayes.NaiveBayesLearnerCustomizer;
import it.cnr.jatecs.indexes.DB.interfaces.ICategoryDB;
import it.cnr.jatecs.indexes.DB.interfaces.IIndex;
import it.cnr.jatecs.indexes.DB.troveCompact.*;
import it.cnr.jatecs.indexing.corpus.BagOfWordsFeatureExtractor;
import it.cnr.jatecs.io.FileSystemStorageManager;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.Map.Entry;
import java.io.PrintWriter;

/**
 * Created by murugesm on 11/29/16.
 */
public class getBusinessData implements Runnable
{
    public getBusinessData(DBCursor cursor, DB db, String method)
    {
        this.cursor = cursor;
        this.db = db;
        this.method = method;
    }

    static final String CLEAR = "CLEAR";
    static final String EXCEPTION = "EXCEPTION";
    static final String CLASSIFY = "CLASSIFY";
    static final String LEARN = "LEARN";
    static final String INDEX = "INDEX";
    static final String INIT = "INIT";
    static final String EXIT = "EXIT";
    static final String SEPARATOR = " ";
    static final String TRAIN = "TRAIN";
    static final String TEST = "TEST";
    static final String[] STRING_ARRAY = new String[0];
    static final String LABEL_SEPARATOR = "|";
    static final String NAIVE_BAYES = "NB";
    static final String OK = "OK";
    static HashSet<String>  exhaustiveList = new HashSet<String>();

    static BagOfWordsFeatureExtractor extractor = new BagOfWordsFeatureExtractor();
    static TroveMainIndexBuilder mainIndexBuilder = null;
    static IIndex training = null;
    static ICategoryDB categoryDB = null;
    static TroveCategoryDBBuilder categoryDBBuilder = new TroveCategoryDBBuilder();
    static IClassifier classifier = null;
    static TroveDependentIndexBuilder testIndexBuilder = null;
    static TroveContentDBType contentDBType = TroveContentDBType.IL;
    static TroveClassificationDBType classificationDBType = TroveClassificationDBType.IL;

    DBCursor cursor;
    DB db;
    String method;

    public static void main(String[] args) throws IOException, InterruptedException
    {
        getJSON();
    }

    public void run()
    {
        String json = null;
        if(method == "train")
        {
            while (cursor.hasNext())
            {
                json = cursor.next().toString();
                json = json.replaceAll("_", "");
                json = json.replaceAll("-", "");
                Gson gson = new Gson();
                Business business1 = gson.fromJson(json, Business.class);
                String[] categories = business1.getCategories();
                ArrayList<String> mainCategories = new ArrayList<String>();

                for (String category : categories)
                {
                    if (exhaustiveList.contains(category))
                    {
                        mainCategories.add(category);
                    }
                }

                String textData = null;
                try
                {
                    textData = getReviewData.getReviews(db, business1.getBusinessid());
                }
                catch (UnknownHostException e)
                {
                    e.printStackTrace();
                }
                extractFeatures(mainIndexBuilder, mainCategories, business1.getName(), textData);

                writeLine("Finished Training " + business1.getName());
            }
        }
        else
        {
            while(cursor.hasNext())
            {
                json = cursor.next().toString();
                json = json.replaceAll("_","");
                json = json.replaceAll("-","");
                Gson gson = new Gson();
                Business business1 = gson.fromJson(json, Business.class);
                String[] categories = business1.getCategories();
                ArrayList<String> mainCategories = new ArrayList<String>();

                for(String category: categories)
                {
                    if(exhaustiveList.contains(category))
                    {
                        mainCategories.add(category);
                    }
                }

                String textData = null;

                try
                {
                    textData = getReviewData.getReviews(db, business1.getBusinessid());
                }
                catch (UnknownHostException e)
                {
                    e.printStackTrace();
                }

                extractFeaturesTest(testIndexBuilder, mainCategories, business1.getName(), textData);

                writeLine("Testing " + business1.getName());
            }

        }
    }

    public static void getJSON() throws IOException, InterruptedException
    {
        exhaustiveList.add("Restaurants");
        exhaustiveList.add("Nightlife");
        exhaustiveList.add("Active Life");
        exhaustiveList.add("Automotive");
        exhaustiveList.add("Home Services");
        exhaustiveList.add("Pets");
        exhaustiveList.add("Public Services & Government");
        exhaustiveList.add("Food");
        exhaustiveList.add("Local Services");
        exhaustiveList.add("Hotels & Travel");
        exhaustiveList.add("Event Planning & Services");
        exhaustiveList.add("Health & Medical");
        exhaustiveList.add("Shopping");
        exhaustiveList.add("Beauty & Spas");
        exhaustiveList.add("Arts & Entertainment");
        exhaustiveList.add("Education");
        exhaustiveList.add("Financial Services");
        exhaustiveList.add("Religious Organizations");
        exhaustiveList.add("Professional Services");
        exhaustiveList.add("Mass Media");
        exhaustiveList.add("Local Flavor");

        String[] labels = {"Restaurants", "Nightlife", "Active Life", "Restaurants", "Automotive", "Home Services", "Pets", "Public Services & Government", "Food", "Local Services", "Hotels & Travel", "Event Planning & Services", "Health & Medical", "Shopping", "Beauty & Spas", "Arts & Entertainment", "Education", "Financial Services", "Religious Organizations", "Professional Services", "Mass Media", "Local Flavor"};

        for (String label : labels)
        {
            categoryDBBuilder.addCategory(label);
        }

        categoryDB = categoryDBBuilder.getCategoryDB();

        mainIndexBuilder = new TroveMainIndexBuilder(categoryDB);

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("yelp_dataset");

        DBCollection business = db.getCollection("business");

        int numOfProcessors = Runtime.getRuntime().availableProcessors();

        int totalBusinesses = business.find().count();

        int totalTrain = (int) (totalBusinesses * 0.8 );

        int window = (int) (totalTrain/ numOfProcessors);

        DBCursor[] cursors = new DBCursor[numOfProcessors];

        Thread[] threads = new Thread[numOfProcessors];

        for(int p=0; p < numOfProcessors; p++)
        {
            cursors[p] = business.find().limit(window).skip(window * p);
            getBusinessData objClass = new getBusinessData(cursors[p], db, "train");
            threads[p] = new Thread(objClass, p + "");
            threads[p].start();
        }

        for(int p=0; p < numOfProcessors; p++)
        {
            try
            {
                threads[p].join();
            }
            catch (Exception e)
            {
                writeLine(e.toString());
            }
        }

        FileSystemStorageManager storageManager = new FileSystemStorageManager("/Users/murugesm/Sem 3/Search/project", false);
        storageManager.open();
        training = TroveReadWriteHelper.generateIndex(storageManager, mainIndexBuilder.getIndex(), contentDBType, classificationDBType);
        testIndexBuilder = new TroveDependentIndexBuilder(training.getDomainDB());
        storageManager.close();

        int totalTests = totalBusinesses - totalTrain;

        window = (int) (totalTests/ numOfProcessors);

        DBCursor[] cursorsTest = new DBCursor[numOfProcessors];

        Thread[] threadsTest = new Thread[numOfProcessors];

        for(int p=0; p < numOfProcessors; p++)
        {
            cursorsTest[p] = business.find().limit(window).skip(window * p);
            //    cursors[p] = business.find().limit((totalTests) - (window * p)).skip(window * p);
            getBusinessData objClass = new getBusinessData(cursorsTest[p], db, "test");
            threadsTest[p] = new Thread(objClass, p + "");
            threadsTest[p].start();
        }

        for(int p=0; p < numOfProcessors; p++)
        {
            try
            {
                threadsTest[p].join();
            }
            catch (Exception e)
            {
                writeLine(e.toString());
            }
        }

        System.out.print("Done Multithreading");
        IIndex testIndex = testIndexBuilder.getIndex();

        NaiveBayesLearner learner = new NaiveBayesLearner();
        NaiveBayesLearnerCustomizer customizer = new NaiveBayesLearnerCustomizer();
        double smooth = 1.0;
        customizer.setSmoothingFactor(smooth);
        customizer.useMultinomialModel();
        learner.setRuntimeCustomizer(customizer);
        classifier = learner.build(training);

        Classifier classifierModule = new Classifier(testIndex, classifier, true);
        classifierModule.exec();

        ClassificationScoreDB confidences = classifierModule.getConfidences();
        int numDoc = testIndex.getDocumentDB().getDocumentsCount();
        writeLine(numDoc + " " + categoryDB.getCategoriesCount());

        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");

        for (int docID = 0; docID < numDoc; ++docID)
        {
            String docName = testIndex.getDocumentDB().getDocumentName(docID);
            Set<Entry<Short, ClassifierRangeWithScore>> entries = confidences.getDocumentScoresAsSet(docID);
            Iterator<Entry<Short, ClassifierRangeWithScore>> iterator = entries.iterator();

            HashMap<String, Double> map = new HashMap<String, Double>();

            while (iterator.hasNext())
            {
                Entry<Short, ClassifierRangeWithScore> next = iterator.next();
                ClassifierRangeWithScore value = next.getValue();

                map.put(categoryDB.getCategoryName(next.getKey()), value.score);
            }

            writer.print("'"+docName+"'");
            writeLine("The top 3 possibility of category for the business "+docName+ " are :");
            Object[] a = map.entrySet().toArray();
            Arrays.sort(a, new Comparator()
            {
                public int compare(Object o1, Object o2)
                {
                    return ((Map.Entry<String, Double>) o2).getValue().compareTo(((Map.Entry<String, Double>) o1).getValue());
                }
            });

            int count = 0;
            for (Object e : a)
            {
                writer.print(" '"+((Map.Entry<String, Double>) e).getKey()+"'");
                System.out.println(((Map.Entry<String, Double>) e).getKey() + " : " + ((Map.Entry<String, Double>) e).getValue());
                count++;
                if(count>2)
                {
                    break;
                }
            }
            writer.println();

            writeLine("------------------------------------------------------------------------");
        }
        writer.close();
    }

    public static void extractFeatures(TroveMainIndexBuilder mainIndexBuilder, ArrayList<String> categories, String businessName, String text)
    {
        List<String> labels1 = new Vector<String>();

        for(String category: categories)
        {
            labels1.add(category);
        }

        List<String> features = extractor.extractFeatures(text);

        try
        {
            mainIndexBuilder.addDocument(businessName, features.toArray(STRING_ARRAY), labels1.toArray(STRING_ARRAY));
        }
        catch (Exception e)
        {
            writeLine("Exception found for document "+businessName+" : "+ e.toString());
        }
    }

    public static void extractFeaturesTest(TroveDependentIndexBuilder testIndexBuilder, ArrayList<String> categories, String businessName, String text)
    {
        List<String> labels1 = new Vector<String>();

        for(String category: categories)
        {
            labels1.add(category);
        }

        List<String> features = extractor.extractFeatures(text);
        try
        {
            testIndexBuilder.addDocument(businessName, features.toArray(STRING_ARRAY), labels1.toArray(STRING_ARRAY));
        }
        catch (Exception e)
        {
            writeLine("Exception found for document "+businessName+" : "+ e.toString());
        }
    }

    private static void writeLine(String line)
    {
        System.out.println(line);
    }
}
