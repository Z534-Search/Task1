package com.search.core.objectStructure;

public class Business
{
    private String review_count;

    private Hours hours;

    private String state;

    private String full_address;

    private String type;

    private String city;

    private String open;

    private String[] neighborhoods;

    private String _id;

    private String stars;

    private String name;

    private String business_id;

    private String[] categories;

    private String longitude;

    private Attributes attributes;

    private String latitude;

    public String getReview_count ()
    {
        return review_count;
    }

    public void setReview_count (String review_count)
    {
        this.review_count = review_count;
    }

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

    public String getFull_address ()
    {
        return full_address;
    }

    public void setFull_address (String full_address)
    {
        this.full_address = full_address;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
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

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
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

    public String getBusiness_id ()
    {
        return business_id;
    }

    public void setBusiness_id (String business_id)
    {
        this.business_id = business_id;
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
        return "Business [review_count = "+review_count+", hours = "+hours+", state = "+state+", full_address = "+full_address+", type = "+type+", city = "+city+", open = "+open+", neighborhoods = "+neighborhoods+", _id = "+_id+", stars = "+stars+", name = "+name+", business_id = "+business_id+", categories = "+categories+", longitude = "+longitude+", attributes = "+attributes+", latitude = "+latitude+"]";
    }
}
/*
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.search.core.UtilFunctions;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class Business {
    private String business_id;
    private String full_address;
    private BusinessHours hours;
    private boolean open;
    private String[] categories;
    private String city;
    private int review_count;
    private String name;
    private String[] neighborhoods;
    private double longitutde;
    private String state;
    private double stars;
    private double latitude;
    private JsonObject attributes;
    private String type;

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getFull_address() {
        return full_address;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }

    public BusinessHours getHours() {
        return hours;
    }

    public void setHours(BusinessHours hours) {
        this.hours = hours;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getNeighborhoods() {
        return neighborhoods;
    }

    public void setNeighborhoods(String[] neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    public double getLongitutde() {
        return longitutde;
    }

    public void setLongitutde(double longitutde) {
        this.longitutde = longitutde;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public JsonObject getAttributes() {
        return attributes;
    }

    public void setAttributes(JsonObject attributes) {
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Business [business_id=" + business_id + ", full_address="
                + full_address + ", hours=" + hours + ", open=" + open
                + ", categories=" + Arrays.toString(categories) + ", city="
                + city + ", review_count=" + review_count + ", name=" + name
                + ", neighborhoods=" + Arrays.toString(neighborhoods)
                + ", longitutde=" + longitutde + ", state=" + state
                + ", stars=" + stars + ", latitude=" + latitude
                + ", attributes=" + attributes + ", type=" + type + "]";
    }

    public void findAllAttributes(String thisline,
                                  ArrayList<String> attributeList) {
        boolean flag = false;
        String[] attributesString = StringUtils.substringsBetween(thisline,
                "\"attributes\": {", "}, \"type\":");
        String[] innerClasses = StringUtils.substringsBetween(
                attributesString[0], "{", "}");
        if (innerClasses != null) {
            for (String str : innerClasses) {
                attributesString[0] = attributesString[0].replace(str, "");
            }
        }
        String[] attributes = attributesString[0].split(",");
        for (String attrib : attributes) {
            attrib = attrib.split(":")[0];
            attrib = attrib.replaceAll("\"", "");
            attrib = attrib.trim();
            if (!attributeList.contains(attrib)) {
                attributeList.add(attrib);
                System.out.println(attrib);
            }
        }
    }

    public static Business jsonStringToBusiness(String json) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String jsonbusiness = json;
        Business business = gson.fromJson(jsonbusiness, Business.class);
        return business;
    }

    public static void readGson() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String jsonbusiness = "{\"business_id\": \"mVHrayjG3uZ_RLHkLj-AMg\", \"full_address\": \"414 Hawkins Ave\nBraddock, PA 15104\", \"hours\": {\"Tuesday\": {\"close\": \"19:00\", \"open\": \"10:00\"}, \"Friday\": {\"close\": \"20:00\", \"open\": \"10:00\"}, \"Saturday\": {\"close\": \"16:00\", \"open\": \"10:00\"}, \"Thursday\": {\"close\": \"19:00\", \"open\": \"10:00\"}, \"Wednesday\": {\"close\": \"19:00\", \"open\": \"10:00\"}}, \"open\": true, \"categories\": [\"Bars\", \"American (New)\", \"Nightlife\", \"Lounges\", \"Restaurants\"], \"city\": \"Braddock\", \"review_count\": 11, \"name\": \"Emil's Lounge\", \"neighborhoods\": [], \"longitude\": -79.866350699999998, \"state\": \"PA\", \"stars\": 4.5, \"latitude\": 40.408735, \"attributes\": {\"Alcohol\": \"full_bar\", \"Noise Level\": \"average\", \"Has TV\": true, \"Attire\": \"casual\", \"Ambience\": {\"romantic\": false, \"intimate\": false, \"classy\": false, \"hipster\": false, \"divey\": false, \"touristy\": false, \"trendy\": false, \"upscale\": false, \"casual\": false}, \"Good for Kids\": true, \"Price Range\": 1, \"Good For Dancing\": false, \"Delivery\": false, \"Coat Check\": false, \"Smoking\": \"no\", \"Accepts Credit Cards\": true, \"Take-out\": true, \"Happy Hour\": false, \"Outdoor Seating\": false, \"Takes Reservations\": false, \"Waiter Service\": true, \"Wi-Fi\": \"no\", \"Caters\": true, \"Good For\": {\"dessert\": false, \"latenight\": false, \"lunch\": false, \"dinner\": false, \"breakfast\": false, \"brunch\": false}, \"Parking\": {\"garage\": false, \"street\": false, \"validated\": false, \"lot\": false, \"valet\": false}, \"Music\": {\"dj\": false}, \"Good For Groups\": true}, \"type\": \"business\"}";
        BufferedReader br;
        ArrayList<String> attributeList = new ArrayList<String>();

        try {
            br = new BufferedReader(
                    new FileReader(
                            UtilFunctions.getMySourcePath()
                                    + "/com/search/project/yelp/dataset/yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_business.json"));
            Business business = gson.fromJson(jsonbusiness, Business.class);
            System.out.println(business);

            Type stringStringMap = new TypeToken<Map<String, Object>>() {
            }.getType();
            Map<String, Object> map = gson.fromJson(business.attributes,
                    stringStringMap);
            System.out.println("attributesMap is: " + map);
            System.out.println("map.Alcohol = " + map.get("Alcohol"));
            System.out.println("map.Ambience = " + map.get("Ambience"));

            GsonBuilder builder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
            Object o = builder.create().fromJson(jsonbusiness, Object.class);
            System.out.println("Object is: " + o);

            String thisline = "";
            int i = 0;
            while ((thisline = br.readLine()) != null) {
                i++;
                business = gson.fromJson(thisline, Business.class);
                business.findAllAttributes(thisline, attributeList);
            }
            System.out.println("Analyzed " + i + " business rows");
            System.out.println("Found " + attributeList.size() + " attributes");
            System.out.println("Arributes List: " + attributeList);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

    public static HashSet<String> getCategoriesList() {
        HashSet<String> categoriesList = new HashSet<>();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

        BufferedReader br;
        try {
            br = new BufferedReader(
                    new FileReader(
                            UtilFunctions.getMySourcePath() +
                                    // "F:/Users/Milind/Documents/GitHub/Z534_Search/src/com/search/project/yelp/dataset/yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_business.json"));
                                    "/com/search/project/yelp/dataset/yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_business.json"));
            String thisline = "";
            int i = 0;
            Business business;
            while ((thisline = br.readLine()) != null) {
                i++;
                business = gson.fromJson(thisline, Business.class);
                for (String str : business.getCategories()) {
                    if (!categoriesList.contains(str))
                        categoriesList.add(str);
                }
            }
            br.close();

        } catch (JsonSyntaxException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return categoriesList;

    }

    public static void main(String[] args) {
        // Business.readGson();
        HashSet<String> catList = Business.getCategoriesList();
        System.out.println("Found " + catList.size() + " categories");
        for (String string : catList) {
            System.out.println(string);
        }
        // System.out.println(catList);

    }
}
*/