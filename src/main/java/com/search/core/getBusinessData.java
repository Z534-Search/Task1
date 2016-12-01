package com.search.core;


import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.search.core.objectStructure.Business;

import java.net.UnknownHostException;
/**
 * Created by murugesm on 11/29/16.
 */
public class getBusinessData
{
    public static void main(String[] args) throws UnknownHostException
    {
        String[] vetti = getJSON();
    }
    /*
    public static DBCursor connectMongo(DBCursor cursor) throws UnknownHostException
    {
        if(cursor.hasNext())
        {
            System.out.println(cursor.next());
        }
        return cursor;
    }
    */
    public static String[] getJSON() throws UnknownHostException
    {
        String json = null;

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("testdb");

        DBCollection business = db.getCollection("business");
        DBCursor cursor = business.find();


        for(int i=0; i < 5; i++)
        {
            if(cursor.hasNext())
            {
                json = cursor.next().toString();
                json = json.replaceAll("_","");
                json = json.replaceAll("-","");
                Gson gson = new Gson();
                Business business1 = gson.fromJson(json, Business.class);
                System.out.println("\n\n");
                System.out.println(business1.getName());
                getReviewData.getReviews(business1.getBusinessid());
                //System.out.println(business1.getBusinessid());
                //System.out.println(json);
            }
        }

        return new String[]{};
    }
}
