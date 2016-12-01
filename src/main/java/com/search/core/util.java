package com.search.core;

import java.util.*;

/**
 * Created by murugesm on 11/29/16.
 */
public class util
{
    public static String removeStopWords(String review)
    {
        return "";
    }

    public static double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }

    public static double idf(List<List<String>> docs, String term) {
        double n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }

    public static double tfIdf(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);
    }

    public static List<List<String>> returnList(List<List<String>> docs, String doc)
    {
        List<String> listOfWords = new ArrayList<String>();
        String[] words = doc.split("\\s+");
        for(String word : words)
        {
            listOfWords.add(word);
        }
        docs.add(listOfWords);
        return docs;
    }
}
