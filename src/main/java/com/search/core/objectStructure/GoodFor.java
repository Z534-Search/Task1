package com.search.core.objectStructure;

/**
 * Created by murugesm on 11/29/16.
 */
public class GoodFor
{
    private String dinner;

    private String latenight;

    private String breakfast;

    private String brunch;

    private String lunch;

    private String dessert;

    public String getDinner ()
    {
        return dinner;
    }

    public void setDinner (String dinner)
    {
        this.dinner = dinner;
    }

    public String getLatenight ()
    {
        return latenight;
    }

    public void setLatenight (String latenight)
    {
        this.latenight = latenight;
    }

    public String getBreakfast ()
    {
        return breakfast;
    }

    public void setBreakfast (String breakfast)
    {
        this.breakfast = breakfast;
    }

    public String getBrunch ()
    {
        return brunch;
    }

    public void setBrunch (String brunch)
    {
        this.brunch = brunch;
    }

    public String getLunch ()
    {
        return lunch;
    }

    public void setLunch (String lunch)
    {
        this.lunch = lunch;
    }

    public String getDessert ()
    {
        return dessert;
    }

    public void setDessert (String dessert)
    {
        this.dessert = dessert;
    }

    @Override
    public String toString()
    {
        return "GoodFor [dinner = "+dinner+", latenight = "+latenight+", breakfast = "+breakfast+", brunch = "+brunch+", lunch = "+lunch+", dessert = "+dessert+"]";
    }
}