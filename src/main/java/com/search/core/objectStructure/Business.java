package com.search.core.objectStructure;

public class Business
{
    private Hours hours;

    private String state;

    private String type;

    private String reviewcount;

    private String city;

    private Id id;

    private String businessid;

    private String open;

    private String[] neighborhoods;

    private String stars;

    private String name;

    private String fulladdress;

    private String[] categories;

    private String longitude;

    private Attributes attributes;

    private String latitude;

    public Hours getHours ()
    {
        return hours;
    }

    public void setHours (Hours hours)
    {
        this.hours = hours;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getReviewcount ()
    {
        return reviewcount;
    }

    public void setReviewcount (String reviewcount)
    {
        this.reviewcount = reviewcount;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public Id getId ()
    {
        return id;
    }

    public void setId (Id id)
    {
        this.id = id;
    }

    public String getBusinessid ()
    {
        return businessid;
    }

    public void setBusinessid (String businessid)
    {
        this.businessid = businessid;
    }

    public String getOpen ()
    {
        return open;
    }

    public void setOpen (String open)
    {
        this.open = open;
    }

    public String[] getNeighborhoods ()
    {
        return neighborhoods;
    }

    public void setNeighborhoods (String[] neighborhoods)
    {
        this.neighborhoods = neighborhoods;
    }

    public String getStars ()
    {
        return stars;
    }

    public void setStars (String stars)
    {
        this.stars = stars;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getFulladdress ()
    {
        return fulladdress;
    }

    public void setFulladdress (String fulladdress)
    {
        this.fulladdress = fulladdress;
    }

    public String[] getCategories ()
    {
        return categories;
    }

    public void setCategories (String[] categories)
    {
        this.categories = categories;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public Attributes getAttributes ()
    {
        return attributes;
    }

    public void setAttributes (Attributes attributes)
    {
        this.attributes = attributes;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    @Override
    public String toString()
    {
        return "Business [hours = "+hours+", state = "+state+", type = "+type+", reviewcount = "+reviewcount+", city = "+city+", id = "+id+", businessid = "+businessid+", open = "+open+", neighborhoods = "+neighborhoods+", stars = "+stars+", name = "+name+", fulladdress = "+fulladdress+", categories = "+categories+", longitude = "+longitude+", attributes = "+attributes+", latitude = "+latitude+"]";
    }
}

