package com.search.core;


import com.mongodb.*;
import com.mongodb.util.JSON;

import java.io.*;
import java.net.UnknownHostException;

public class ImportDataToMongo
{
    public ImportDataToMongo()
    {

    }
    public static void insert(String pathToFile, DB db, String collectionName)
    {
        FileInputStream fstream = null;
        try
        {
            fstream = new FileInputStream(pathToFile);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("file not exist, exiting");
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        DBCollection newColl =   db.getCollection(collectionName);
        try
        {
            while ((strLine = br.readLine()) != null)
            {
                DBObject bson = (DBObject) JSON.parse(strLine);
                try
                {
                    newColl.insert(bson);
                }
                catch (MongoException e)
                {
                    e.printStackTrace();
                }
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Inserted "+Integer.toString(newColl.find().count()) + " rows into the table " + newColl.toString());
    }
    public static void main(String path)
    {
        try
        {
            MongoClient mongo = new MongoClient("localhost", 27017);

            DB db = mongo.getDB("yelp_dataset");

            insert(path+"/yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_business.json",db,"business");

            insert(path+"/yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_review.json",db,"review");

            insert(path+"/yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_review.json",db,"tip");

            System.out.println("Done inserting values into Mongo");
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (MongoException e)
        {
            e.printStackTrace();
        }
    }

}
