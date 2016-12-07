package com.search.core.objectStructure;

/**
 * Created by murugesm on 11/29/16.
 */
public class Hours
{
    private BusinessDay Thursday;

    private BusinessDay Monday;

    private BusinessDay Tuesday;

    private BusinessDay Wednesday;

    private BusinessDay Friday;

    public BusinessDay getThursday ()
    {
        return Thursday;
    }

    public void setThursday (BusinessDay Thursday)
    {
        this.Thursday = Thursday;
    }

    public BusinessDay getMonday ()
    {
        return Monday;
    }

    public void setMonday (BusinessDay Monday)
    {
        this.Monday = Monday;
    }

    public BusinessDay getTuesday ()
    {
        return Tuesday;
    }

    public void setTuesday (BusinessDay Tuesday)
    {
        this.Tuesday = Tuesday;
    }

    public BusinessDay getWednesday ()
    {
        return Wednesday;
    }

    public void setWednesday (BusinessDay Wednesday)
    {
        this.Wednesday = Wednesday;
    }

    public BusinessDay getFriday ()
    {
        return Friday;
    }

    public void setFriday (BusinessDay Friday)
    {
        this.Friday = Friday;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Thursday = "+Thursday+", Monday = "+Monday+", Tuesday = "+Tuesday+", Wednesday = "+Wednesday+", Friday = "+Friday+"]";
    }
}