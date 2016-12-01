package com.search.core.objectStructure;

/**
 * Created by murugesm on 11/29/16.
 */
public class Votes
{
    private String cool;

    private String funny;

    private String useful;

    public String getCool ()
    {
        return cool;
    }

    public void setCool (String cool)
    {
        this.cool = cool;
    }

    public String getFunny ()
    {
        return funny;
    }

    public void setFunny (String funny)
    {
        this.funny = funny;
    }

    public String getUseful ()
    {
        return useful;
    }

    public void setUseful (String useful)
    {
        this.useful = useful;
    }

    @Override
    public String toString()
    {
        return "Votes [cool = "+cool+", funny = "+funny+", useful = "+useful+"]";
    }
}