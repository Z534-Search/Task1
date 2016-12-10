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
    public static String getReviews(DB db, String businessID) throws UnknownHostException
    {
        String json = null;

        DBCollection business = db.getCollection("review");

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("business_id", businessID);

        DBCursor cursor = business.find(whereQuery);

        String allReviews = "";

        while(cursor.hasNext())
        {
            json = cursor.next().toString();
            json = json.replaceAll("_","");
            json = json.replaceAll("-","");
            Gson gson = new Gson();
            Review review = gson.fromJson(json, Review.class);

            String features = StopWords.removeStemmedStopWords(review.getText());

            allReviews += " " + features;
        }

        cursor.close();
        return allReviews;
    }
}
