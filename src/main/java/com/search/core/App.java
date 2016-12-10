package com.search.core;

import java.io.IOException;

public class App
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        try
        {
            System.out.println("Inserting Data into Mongo");
            ImportDataToMongo.main();
        }
        catch (Exception e)
        {
            System.out.println("Error inserting data into Mongo");
        }

        getBusinessData.getJSON();
    }
}