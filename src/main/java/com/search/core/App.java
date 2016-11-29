package com.search.core;

public class App
{
    public static void main(String[] args)
    {
        try
        {
            ImportDataToMongo.main();
        }
        catch (Exception e)
        {
            System.out.println("Error inserting data into Mongo");
        }
    }
}