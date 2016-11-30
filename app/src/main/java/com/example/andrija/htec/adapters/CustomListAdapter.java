package com.example.andrija.htec.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.andrija.htec.R;
import com.example.andrija.htec.models.ListItemModel;

import java.util.ArrayList;


public class CustomListAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<ListItemModel> items; //data source of the list adapter

    //public constructor
    public CustomListAdapter(Context context, ArrayList<ListItemModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.custom_list_item, parent, false);
        }

        // get current item to be displayed
        ListItemModel currentItem = (ListItemModel) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.title);
        TextView textViewItemDescription = (TextView)
                convertView.findViewById(R.id.description);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(currentItem.getTitle());
        textViewItemDescription.setText(currentItem.getDescription());

        // returns the view for the current row
        return convertView;
    }
}
