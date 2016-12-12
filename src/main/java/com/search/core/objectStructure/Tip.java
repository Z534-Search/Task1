package com.search.core.objectStructure;

/**
 * Created by murugesm on 12/12/2016.
 */
public class Tip
{
    private String text;

    private String review_id;

    private Id id;

    private String stars;

    private String business_id;

    private Votes votes;

    private String user_id;

    private String type;

    private String date;

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getReview_id ()
    {
        return review_id;
    }

    public void setReview_id (String review_id)
    {
        this.review_id = review_id;
    }

    public Id get_id ()
    {
        return id;
    }

    public void set_id (Id id)
    {
        this.id = id;
    }

    public String getStars ()
    {
        return stars;
    }

    public void setStars (String stars)
    {
        this.stars = stars;
    }

    public String getBusiness_id ()
    {
        return business_id;
    }

    public void setBusiness_id (String business_id)
    {
        this.business_id = business_id;
    }

    public Votes getVotes ()
    {
        return votes;
    }

    public void setVotes (Votes votes)
    {
        this.votes = votes;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
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
        return "ClassPojo [text = "+text+", review_id = "+review_id+", _id = "+id+", stars = "+stars+", business_id = "+business_id+", votes = "+votes+", user_id = "+user_id+", type = "+type+", date = "+date+"]";
    }
}