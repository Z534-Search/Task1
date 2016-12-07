package com.search.core.objectStructure;

/**
 * Created by murugesm on 11/29/16.
 */
public class Review
{
    private Id id;

    private String businessid;

    private String text;

    private String stars;

    private String userid;

    private Votes votes;

    private String reviewid;

    private String type;

    private String date;

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

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getStars ()
    {
        return stars;
    }

    public void setStars (String stars)
    {
        this.stars = stars;
    }

    public String getUserid ()
    {
        return userid;
    }

    public void setUserid (String userid)
    {
        this.userid = userid;
    }

    public Votes getVotes ()
    {
        return votes;
    }

    public void setVotes (Votes votes)
    {
        this.votes = votes;
    }

    public String getReviewid ()
    {
        return reviewid;
    }

    public void setReviewid (String reviewid)
    {
        this.reviewid = reviewid;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "Review [id = "+id+", businessid = "+businessid+", text = "+text+", stars = "+stars+", userid = "+userid+", votes = "+votes+", reviewid = "+reviewid+", type = "+type+", date = "+date+"]";
    }
}