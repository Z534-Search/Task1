package com.search.core.objectStructure;

/**
 * Created by murugesm on 11/29/16.
 */

public class BusinessDay
{
        private String open;

        private String close;

        public String getOpen ()
        {
            return open;
        }

        public void setOpen (String open)
        {
            this.open = open;
        }

        public String getClose ()
        {
            return close;
        }

        public void setClose (String close)
        {
            this.close = close;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [open = "+open+", close = "+close+"]";
        }
    }