package com.search.core;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.search.core.objectStructure.Tip;

import java.net.UnknownHostException;


/**
 * Created by murugesm on 11/12/2016.
 */
public class getTipData
{
    public static String getTips(DB db, String businessID) throws UnknownHostException
    {
        String json = null;

        DBCollection Tip = db.getCollection("tip");

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("business_id", businessID);

        DBCursor cursor = Tip.find(whereQuery);

        String allTip = "";

        System.out.println(cursor.next());

        while(cursor.hasNext())
        {
            json = cursor.next().toString();
            json = json.replaceAll("_","");
            json = json.replaceAll("-","");
            Gson gson = new Gson();
            Tip tip = gson.fromJson(json, Tip.class);

            String features = StopWords.removeStemmedStopWords(tip.getText());

            allTip += " " + features;
        }

        cursor.close();
        return allTip;
    }
}
