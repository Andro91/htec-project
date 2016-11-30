package com.example.andrija.htec.models;

/**
 * Created by Andrija on 29-Nov-16.
 */

public class ListItemModel {

    private String mImage;
    private String mTitle;
    private String mDescription;

    public ListItemModel(String image, String title, String description) {
        this.mImage = image;
        this.mTitle = title;
        this.mDescription = description;
    }

    public String getImage() {
        //Picasso can't load images over http, URL has to be changed to https
        return mImage.replace("http", "https");
    }

    public void setImage(String mImage) {
        this.mImage = mImage;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mText) {
        this.mDescription = mText;
    }
}
