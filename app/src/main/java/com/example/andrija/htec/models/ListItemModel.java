package com.example.andrija.htec.models;

import android.webkit.URLUtil;

import java.net.MalformedURLException;

/**
 * Created by Andrija on 29-Nov-16.
 * The model class for the ListView list item
 */

public class ListItemModel {

    private String mImage;
    private String mTitle;
    private String mDescription;

    public ListItemModel(String image, String title, String description) throws MalformedURLException {
        this.mTitle = title;
        setImage(image);
        this.mDescription = description;
    }

    public String getImage() {
        //Picasso can't load images over http, URL has to be changed to https
        String httpsUrl;
        if (mImage.contains("http://")){
            httpsUrl = mImage.replace("http://", "https://");
        } else {
            httpsUrl = mImage;
        }
        return httpsUrl;
    }

    public void setImage(String mImage) throws MalformedURLException {
        if (URLUtil.isValidUrl(mImage)){
            this.mImage = mImage;
        }else {
            throw new MalformedURLException();
        }

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
