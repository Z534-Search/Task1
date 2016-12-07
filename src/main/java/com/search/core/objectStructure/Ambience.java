package com.search.core.objectStructure;

/**
 * Created by murugesm on 11/29/16.
 */
public class Ambience
{
    private String hipster;

    private String classy;

    private String touristy;

    private String divey;

    private String casual;

    private String intimate;

    private String romantic;

    private String trendy;

    private String upscale;

    public String getHipster ()
    {
        return hipster;
    }

    public void setHipster (String hipster)
    {
        this.hipster = hipster;
    }

    public String getClassy ()
    {
        return classy;
    }

    public void setClassy (String classy)
    {
        this.classy = classy;
    }

    public String getTouristy ()
    {
        return touristy;
    }

    public void setTouristy (String touristy)
    {
        this.touristy = touristy;
    }

    public String getDivey ()
    {
        return divey;
    }

    public void setDivey (String divey)
    {
        this.divey = divey;
    }

    public String getCasual ()
    {
        return casual;
    }

    public void setCasual (String casual)
    {
        this.casual = casual;
    }

    public String getIntimate ()
    {
        return intimate;
    }

    public void setIntimate (String intimate)
    {
        this.intimate = intimate;
    }

    public String getRomantic ()
    {
        return romantic;
    }

    public void setRomantic (String romantic)
    {
        this.romantic = romantic;
    }

    public String getTrendy ()
    {
        return trendy;
    }

    public void setTrendy (String trendy)
    {
        this.trendy = trendy;
    }

    public String getUpscale ()
    {
        return upscale;
    }

    public void setUpscale (String upscale)
    {
        this.upscale = upscale;
    }

    @Override
    public String toString()
    {
        return "Ambience [hipster = "+hipster+", classy = "+classy+", touristy = "+touristy+", divey = "+divey+", casual = "+casual+", intimate = "+intimate+", romantic = "+romantic+", trendy = "+trendy+", upscale = "+upscale+"]";
    }
}

