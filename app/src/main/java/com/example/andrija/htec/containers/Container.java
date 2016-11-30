package com.example.andrija.htec.containers;

import com.example.andrija.htec.models.ListItemModel;

import java.util.ArrayList;

/**
 * Created by Andrija on 30-Nov-16.
 * Container class intended to persist the data parsed form the web service
 */
public class Container {

    private static Container instance = null;
    private ArrayList<ListItemModel> mData;

    protected Container() {
        // Exists only to defeat instantiation.
    }
    public static Container getInstance() {
        if(instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public ArrayList<ListItemModel> getData() {
        return this.mData;
    }

    public void setData(ArrayList<ListItemModel> data) {
        this.mData = data;
    }
}
