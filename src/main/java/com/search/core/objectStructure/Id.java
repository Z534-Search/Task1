package com.search.core.objectStructure;

/**
 * Created by murugesm on 11/29/16.
 */
public class Id
{
    private String $oid;

    public String get$oid ()
    {
        return $oid;
    }

    public void set$oid (String $oid)
    {
        this.$oid = $oid;
    }

    @Override
    public String toString()
    {
        return "Id [$oid = "+$oid+"]";
    }
}