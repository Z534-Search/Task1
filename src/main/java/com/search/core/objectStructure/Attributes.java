package com.search.core.objectStructure;

/**
 * Created by murugesm on 11/29/16.
 */
public class Attributes
{
    private String Alcohol;

    private String WaiterService;

    private String Delivery;

    private String Attire;

    private String GoodforKids;

    private String DriveThru;

    private Parking Parking;

    private String Takeout;

    private String AcceptsCreditCards;

    private String PriceRange;

    private String TakesReservations;

    private String Caters;

    private String NoiseLevel;

    private Ambience Ambience;

    private GoodFor GoodFor;

    private String HasTV;

    private String GoodForGroups;

    private String OutdoorSeating;

    public String getAlcohol ()
    {
        return Alcohol;
    }

    public void setAlcohol (String Alcohol)
    {
        this.Alcohol = Alcohol;
    }

    public String getWaiterService ()
{
    return WaiterService;
}

    public void setWaiterService (String WaiterService)
{
    this.WaiterService = WaiterService;
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

    public String getGoodforKids ()
{
    return GoodforKids;
}

    public void setGoodforKids (String GoodforKids)
{
    this.GoodforKids = GoodforKids;
}

    public String getDriveThru ()
{
    return DriveThru;
}

    public void setDriveThru (String DriveThru)
{
    this.DriveThru = DriveThru;
}

    public Parking getParking ()
    {
        return Parking;
    }

    public void setParking (Parking Parking)
    {
        this.Parking = Parking;
    }

    public String getTakeout ()
{
    return Takeout;
}

    public void setTakeout (String Takeout)
{
    this.Takeout = Takeout;
}

    public String getAcceptsCreditCards ()
{
    return AcceptsCreditCards;
}

    public void setAcceptsCreditCards (String AcceptsCreditCards)
{
    this.AcceptsCreditCards = AcceptsCreditCards;
}

    public String getPriceRange ()
{
    return PriceRange;
}

    public void setPriceRange (String PriceRange)
{
    this.PriceRange = PriceRange;
}

    public String getTakesReservations ()
{
    return TakesReservations;
}

    public void setTakesReservations (String TakesReservations)
{
    this.TakesReservations = TakesReservations;
}

    public String getCaters ()
    {
        return Caters;
    }

    public void setCaters (String Caters)
    {
        this.Caters = Caters;
    }

    public String getNoiseLevel ()
{
    return NoiseLevel;
}

    public void setNoiseLevel (String NoiseLevel)
{
    this.NoiseLevel = NoiseLevel;
}

    public Ambience getAmbience ()
    {
        return Ambience;
    }

    public void setAmbience (Ambience Ambience)
    {
        this.Ambience = Ambience;
    }

    public GoodFor getGoodFor ()
{
    return GoodFor;
}

    public void setGoodFor (GoodFor GoodFor)
{
    this.GoodFor = GoodFor;
}

    public String getHasTV ()
{
    return HasTV;
}

    public void setHasTV (String HasTV)
{
    this.HasTV = HasTV;
}

    public String getGoodForGroups ()
{
    return GoodForGroups;
}

    public void setGoodForGroups (String GoodForGroups)
{
    this.GoodForGroups = GoodForGroups;
}

    public String getOutdoorSeating ()
{
    return OutdoorSeating;
}

    public void setOutdoorSeating (String OutdoorSeating)
{
    this.OutdoorSeating = OutdoorSeating;
}

    @Override
    public String toString()
    {
        return "Attributes [Alcohol = "+Alcohol+", WaiterService = "+WaiterService+", Delivery = "+Delivery+", Attire = "+Attire+", GoodforKids = "+GoodforKids+", DriveThru = "+DriveThru+", Parking = "+Parking+", Takeout = "+Takeout+", AcceptsCreditCards = "+AcceptsCreditCards+", PriceRange = "+PriceRange+", TakesReservations = "+TakesReservations+", Caters = "+Caters+", NoiseLevel = "+NoiseLevel+", Ambience = "+Ambience+", GoodFor = "+GoodFor+", HasTV = "+HasTV+", GoodForGroups = "+GoodForGroups+", OutdoorSeating = "+OutdoorSeating+"]";
    }
}