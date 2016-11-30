package com.example.andrija.htec;

import android.app.ActionBar;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrija.htec.containers.Container;
import com.example.andrija.htec.models.ListItemModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ActionBar actionBar = getActionBar();

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        int itemIndex = getIntent().getIntExtra("itemId", 1);

        ArrayList<ListItemModel> data = Container.getInstance().getData();

        ListItemModel listItemModel = data.get(itemIndex);

        TextView detailsTitle = (TextView) findViewById(R.id.detailsTitle);
        ImageView detailsImage = (ImageView) findViewById(R.id.detailsImage);
        TextView detailsDescription = (TextView) findViewById(R.id.detailsDescription);

        detailsTitle.setText(listItemModel.getTitle());
        detailsDescription.setText(listItemModel.getDescription());

        Picasso.with(this).load(listItemModel.getImage()).into(detailsImage);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
