package com.search.core;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.search.core.objectStructure.Business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * Created by murugesm on 12/6/16.
 */
public class generateGroundTruth
{
    static HashSet<String> exhaustiveList = new HashSet<String>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        writeTruth();
    }

    public static void writeTruth() throws IOException, InterruptedException
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

        MongoClient mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("yelp_dataset");

        DBCollection business = db.getCollection("business");

        int totalBusinesses = business.find().count();
        int totalTrain = (int) (totalBusinesses * 0.8 );
        int totalTests = totalBusinesses - totalTrain;

        DBCursor groundTruthCursor = business.find();

        PrintWriter writer = new PrintWriter("groundtruth.txt", "UTF-8");

        String json = null;

        while(groundTruthCursor.hasNext())
        {
            json = groundTruthCursor.next().toString();
            json = json.replaceAll("_", "");
            json = json.replaceAll("-", "");
            Gson gson = new Gson();
            Business business1 = gson.fromJson(json, Business.class);
            String[] categories = business1.getCategories();

            writer.print("'"+business1.getName()+"'");

            for(String category:categories)
            {
                if(exhaustiveList.contains(category))
                {
                    writer.print(" '" + category + "'");
                }
            }

            writer.println();
        }
        writer.close();
    }
}
