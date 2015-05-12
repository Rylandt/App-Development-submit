package com.example.ryl13138884.flickrapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TopLocations extends ActionBarActivity {

    private ListView listLocations;

    private List<TopLocationObject> topLocations;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_locations);


    listLocations = (ListView)findViewById(R.id.listLocations);

       // Cities = new ArrayList<String>();

        topLocations = new ArrayList<TopLocationObject>();

        topLocations.add( new TopLocationObject("Bath", "England", R.drawable.england, "http://upload.wikimedia.org/wikipedia/commons/3/31/Royal.crescent.aerial.bath.arp.jpg", "12056"));
        topLocations.add( new TopLocationObject("Beijing", "China", R.drawable.china,"http://upload.wikimedia.org/wikipedia/commons/d/dd/Beijing_montage.png", "1118370"));
        topLocations.add( new TopLocationObject("Berlin", "Germany", R.drawable.germany,"http://upload.wikimedia.org/wikipedia/commons/8/83/Berlin_-_Siegessaeule_Aussicht_10-13_img4_Tiergarten_%28cropped%29.jpg", "638242"));
        topLocations.add( new TopLocationObject("London", "England", R.drawable.unitedkingdom,"http://upload.wikimedia.org/wikipedia/commons/3/3a/London_from_a_hot_air_balloon.jpg ", "44418"));
        topLocations.add( new TopLocationObject("Lisbon", "Portugal", R.drawable.portugal, "http://upload.wikimedia.org/wikipedia/commons/4/43/Poster_Lisbon.jpg" , "742676"));
        topLocations.add( new TopLocationObject("Madrid", "Spain", R.drawable.spain,"http://upload.wikimedia.org/wikipedia/commons/e/e6/CollageMadrid.jpg","2151330"));
        topLocations.add( new TopLocationObject("Pyongyang", "North Korea", R.drawable.northkorea, "http://upload.wikimedia.org/wikipedia/commons/b/b1/Pyongyang_montage.png", "1079132"));
        topLocations.add( new TopLocationObject("Washington DC", "United States of America", R.drawable.unitedstates,"http://upload.wikimedia.org/wikipedia/commons/0/0e/DCmontage4.jpg", "2514815"));


        LocationAdapter adapter = new LocationAdapter(topLocations);

        listLocations.setAdapter(adapter);

        listLocations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("FLICKR_TAG", "clicked on = " + position);

                Intent i = new Intent(com.example.ryl13138884.flickrapp.TopLocations.this, SpecificLocationActivity.class);

                i.putExtra("EXTRA_TOP_LOCATION", topLocations.get(position));

                startActivity(i);
            }
        });

    }



    private class LocationAdapter extends ArrayAdapter<TopLocationObject> {

        public LocationAdapter(List<TopLocationObject> items) {
            super(com.example.ryl13138884.flickrapp.TopLocations.this, 0, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(
                        R.layout.locations_layout, null);
            }

            ImageView CountryFlag = (ImageView)convertView.findViewById(R.id.CountryFlag);
            TextView CityName = (TextView)convertView.findViewById(R.id.CityName);
            TextView CountryName = (TextView)convertView.findViewById(R.id.CountryName);


            TopLocationObject LocationInfo = topLocations.get(position);


            CountryFlag.setImageResource(LocationInfo.getFlagResource());
            CityName.setText(LocationInfo.getCityName());
            CountryName.setText(LocationInfo.getCountryName());

            return convertView;
        }// end get view

    }// end adapter class


}
