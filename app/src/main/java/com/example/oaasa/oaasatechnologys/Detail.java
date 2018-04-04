package com.example.oaasa.oaasatechnologys;

/**
 * Created by Amit on 7/18/2017.
 */

public class Detail {
    String Title,PostDate,ShortDescription,LongDescription;

    public Detail(String title, String postDate, String shortDescription, String longDescription) {
        Title = title;
        PostDate = postDate;
        ShortDescription = shortDescription;
        LongDescription = longDescription;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPostDate() {
        return PostDate;
    }

    public void setPostDate(String postDate) {
        PostDate = postDate;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        ShortDescription = shortDescription;
    }

    public String getLongDescription() {
        return LongDescription;
    }

    public void setLongDescription(String longDescription) {
        LongDescription = longDescription;
    }
}
