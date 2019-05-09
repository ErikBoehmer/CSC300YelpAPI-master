package com.example.csc300yelpapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    public static ListofRestNames<String> Restnames;

    public static ArrayAdapter<String> restraunts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Restname = (TextView) findViewById(R.id.RestName_TV);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item Restnames);
        TextView.setAdapter(adapter);
        YelpAPI yelp = new YelpAPI();
        yelp.start();
    }
}
