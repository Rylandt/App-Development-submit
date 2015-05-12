package com.example.ryl13138884.flickrapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Button btnSearch;
    private Button btnTopPhotos;
    private Button btnTopLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnTopPhotos = (Button)findViewById(R.id.btnTopPhotos);
        btnTopLocations = (Button)findViewById(R.id.btnTopLocations);




        btnSearch.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.ryl13138884.flickrapp.MainActivity.this, "Clicked Profile", Toast.LENGTH_SHORT).show();

                Log.d("FLICKR_APP", "pushed Profile button");


                Intent i = new Intent(com.example.ryl13138884.flickrapp.MainActivity.this, Profile.class);
                startActivity(i);
            }
        });

        btnTopPhotos.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.ryl13138884.flickrapp.MainActivity.this, "Under Development", Toast.LENGTH_SHORT).show();

                Log.d("FLICKR_APP", "Under Development");

                Intent i = new Intent(com.example.ryl13138884.flickrapp.MainActivity.this, TopPhotographs.class);
                startActivity(i);
            }
        });

        btnTopLocations.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.ryl13138884.flickrapp.MainActivity.this, "Pressed Top Locations", Toast.LENGTH_SHORT).show();

                Log.d("FLICKR_APP", "Locations loading");

                Intent i = new Intent(com.example.ryl13138884.flickrapp.MainActivity.this, TopLocations.class);
                startActivity(i);
            }
        });
    }





}