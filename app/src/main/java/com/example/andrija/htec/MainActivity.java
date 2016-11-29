package com.example.andrija.htec;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.andrija.htec.models.ListItem;

import java.util.ArrayList;

public class MainActivity extends Activity {

    //JSON key strings
    private static final String KEY_IMAGE = "image";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";


    // URL of array to be parsed
    String JsonUrl = "https://raw.githubusercontent.com/danieloskarsson/mobile-coding-exercise/master/items.json";
    // This ArrayList will hold the results
    ArrayList<ListItem> data = new ArrayList<>();
    // Defining the Volley request queue that handles the URL request concurrently
    RequestQueue requestQueue;
    //MainActivity ListView
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest arrayRequest = new JsonArrayRequest(JsonUrl,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                String image = jsonObject.getString(KEY_IMAGE);
                                String title = jsonObject.getString(KEY_TITLE);
                                String description = jsonObject.getString(KEY_DESCRIPTION);

                                ListItem listItem = new ListItem(image,title,description);

                                data.add(i,listItem);
                            }

                            initializeListView(listView);

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );

        requestQueue.add(arrayRequest);


    }

    public void initializeListView(ListView listView){

    }
}
