package com.search.core;

import com.google.gson.Gson;
import com.mongodb.*;
import com.search.core.objectStructure.Review;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by murugesm on 11/29/16.
 */
public class getReviewData
{
    public static void main(String[] args) throws UnknownHostException
    {
        //String[] vetti = getReviews();
    }

    public static String[] getReviews(String businessID) throws UnknownHostException
    {
        String json = null;

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("testdb");

        DBCollection business = db.getCollection("review");

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("business_id", businessID);

        DBCursor cursor = business.find(whereQuery);

        List<List<String>> listOfWords = new ArrayList<>();

        while(cursor.hasNext())
        {
            json = cursor.next().toString();
            json = json.replaceAll("_","");
            json = json.replaceAll("-","");
            Gson gson = new Gson();
            Review review = gson.fromJson(json, Review.class);

            //System.out.println((review.getText()));
            listOfWords = util.returnList(listOfWords, StopWords.removeStemmedStopWords(review.getText()));
            /*System.out.println("-------------------------------");
            System.out.println(StopWords.removeStopWords(review.getText()));
            System.out.println("-------------------------------");
            System.out.println();*/
            //System.out.println(json);
        }

        cursor = business.find(whereQuery);
        int i = 0;

        while(cursor.hasNext())
        {
            json = cursor.next().toString();
            json = json.replaceAll("_","");
            json = json.replaceAll("-","");
            Gson gson = new Gson();
            Review review = gson.fromJson(json, Review.class);

            //Iterator<List<String>> sIterator = listOfWords.iterator();
            System.out.println((review.getText()));
            for(String word : StopWords.removeStemmedStopWords(review.getText()).split("\\s+"))
            {
                System.out.println("Term : "+ word + " - " + util.tfIdf(listOfWords.get(i),listOfWords,word));
            }
            /*System.out.println("-------------------------------");
            System.out.println(StopWords.removeStopWords(review.getText()));
            System.out.println("-------------------------------");
            System.out.println();*/
            //System.out.println(json);
            i++;
        }

        return new String[]{};
    }
}
