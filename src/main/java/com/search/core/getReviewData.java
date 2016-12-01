package com.search.core;

import com.google.gson.Gson;
import com.mongodb.*;
import com.search.core.objectStructure.Review;

import java.net.UnknownHostException;
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


        while(cursor.hasNext())
        {
            json = cursor.next().toString();
            json = json.replaceAll("_","");
            json = json.replaceAll("-","");
            Gson gson = new Gson();
            Review review = gson.fromJson(json, Review.class);

            System.out.println((review.getText()));
            System.out.println("-------------------------------");
            System.out.println(StopWords.removeStopWords(review.getText()));
            System.out.println("-------------------------------");
            System.out.println(StopWords.removeStemmedStopWords(review.getText()));
            //System.out.println(json);
        }

        return new String[]{};
    }
}
