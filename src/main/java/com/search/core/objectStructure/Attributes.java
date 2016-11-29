package com.search.core.objectStructure;

/**
 * Created by murugesm on 11/29/16.
 */
public class Attributes
{
    private String Alcohol;

    private String Waiter_Service;

    private String Delivery;

    private String Attire;

    private String Good_for_Kids;

    private String Drive_Thru;

    private Parking Parking;

    private String Take_out;

    private String Accepts_Credit_Cards;

    private String Price_Range;

    private String Takes_Reservations;

    private String Caters;

    private String Noise_Level;

    private Ambience Ambience;

    private GoodFor Good_For;

    private String Has_TV;

    private String Good_For_Groups;

    private String Outdoor_Seating;

    public String getAlcohol ()
    {
        return Alcohol;
    }

    public void setAlcohol (String Alcohol)
    {
        this.Alcohol = Alcohol;
    }

    public String getWaiter_Service ()
{
    return Waiter_Service;
}

    public void setWaiter_Service (String Waiter_Service)
{
    this.Waiter_Service = Waiter_Service;
}

    public String getDelivery ()
    {
        return Delivery;
    }

    public void setDelivery (String Delivery)
    {
        this.Delivery = Delivery;
    }

    public String getAttire ()
    {
        return Attire;
    }

    public void setAttire (String Attire)
    {
        this.Attire = Attire;
    }

    public String getGood_for_Kids ()
{
    return Good_for_Kids;
}

    public void setGood_for_Kids (String Good_for_Kids)
{
    this.Good_for_Kids = Good_for_Kids;
}

    public String getDrive_Thru ()
{
    return Drive_Thru;
}

    public void setDrive_Thru (String Drive_Thru)
{
    this.Drive_Thru = Drive_Thru;
}

    public Parking getParking ()
    {
        return Parking;
    }

    public void setParking (Parking Parking)
    {
        this.Parking = Parking;
    }

    public String getTake_out ()
{
    return Take_out;
}

    public void setTake_out (String Take_out)
{
    this.Take_out = Take_out;
}

    public String getAccepts_Credit_Cards ()
{
    return Accepts_Credit_Cards;
}

    public void setAccepts_Credit_Cards (String Accepts_Credit_Cards)
{
    this.Accepts_Credit_Cards = Accepts_Credit_Cards;
}

    public String getPrice_Range ()
{
    return Price_Range;
}

    public void setPrice_Range (String Price_Range)
{
    this.Price_Range = Price_Range;
}

    public String getTakes_Reservations ()
{
    return Takes_Reservations;
}

    public void setTakes_Reservations (String Takes_Reservations)
{
    this.Takes_Reservations = Takes_Reservations;
}

    public String getCaters ()
    {
        return Caters;
    }

    public void setCaters (String Caters)
    {
        this.Caters = Caters;
    }

    public String getNoise_Level ()
{
    return Noise_Level;
}

    public void setNoise_Level (String Noise_Level)
{
    this.Noise_Level = Noise_Level;
}

    public Ambience getAmbience ()
    {
        return Ambience;
    }

    public void setAmbience (Ambience Ambience)
    {
        this.Ambience = Ambience;
    }

    public GoodFor getGood_For ()
{
    return Good_For;
}

    public void setGood_For (GoodFor Good_For)
{
    this.Good_For = Good_For;
}

    public String getHas_TV ()
{
    return Has_TV;
}

    public void setHas_TV (String Has_TV)
{
    this.Has_TV = Has_TV;
}

    public String getGood_For_Groups ()
{
    return Good_For_Groups;
}

    public void setGood_For_Groups (String Good_For_Groups)
{
    this.Good_For_Groups = Good_For_Groups;
}

    public String getOutdoor_Seating ()
{
    return Outdoor_Seating;
}

    public void setOutdoor_Seating (String Outdoor_Seating)
{
    this.Outdoor_Seating = Outdoor_Seating;
}

    @Override
    public String toString()
    {
        return "Attributes [Alcohol = "+Alcohol+", Waiter_Service = "+Waiter_Service+", Delivery = "+Delivery+", Attire = "+Attire+", Good_for_Kids = "+Good_for_Kids+", Drive_Thru = "+Drive_Thru+", Parking = "+Parking+", Take_out = "+Take_out+", Accepts_Credit_Cards = "+Accepts_Credit_Cards+", Price_Range = "+Price_Range+", Takes_Reservations = "+Takes_Reservations+", Caters = "+Caters+", Noise_Level = "+Noise_Level+", Ambience = "+Ambience+", Good_For = "+Good_For+", Has_TV = "+Has_TV+", Good_For_Groups = "+Good_For_Groups+", Outdoor_Seating = "+Outdoor_Seating+"]";
    }
}