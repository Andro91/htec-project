package com.example.andrija.htec.models;

/**
 * Created by Andrija on 29-Nov-16.
 */

public class ListItem {

    private String mImage;
    private String mTitle;
    private String mDescription;

    public ListItem(String image, String title, String description) {
        this.mImage = image;
        this.mTitle = title;
        this.mDescription = description;
    }

    public String getmImage() {
        return mImage;
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
