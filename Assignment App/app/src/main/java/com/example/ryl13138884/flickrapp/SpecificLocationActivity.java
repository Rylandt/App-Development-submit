package com.example.ryl13138884.flickrapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class SpecificLocationActivity extends ActionBarActivity {

    private TextView lblLocationTitle;
    private TextView lblCountryName;
    private ImageView lblCountryFlag;

    private GridView gridView;
    private List<String> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_location);

        TopLocationObject location = (TopLocationObject) getIntent().getSerializableExtra("EXTRA_TOP_LOCATION");

        lblLocationTitle = (TextView)findViewById(R.id.lblLocationTitle);
        lblCountryName = (TextView)findViewById(R.id.lblCountryName);
        lblCountryFlag = (ImageView)findViewById(R.id.lblCountryFlag);

        gridView = (GridView)findViewById(R.id.gridView);
        photos = new ArrayList<>();


        lblLocationTitle.setText(location.getCityName());
        lblCountryName.setText(location.getCountryName());
        lblCountryFlag.setImageResource(location.getFlagResource());


        ImageView lblCountryLocation = (ImageView)findViewById(R.id.lblCountryLocation);
        Picasso.with(SpecificLocationActivity.this).load(location.getMapPictureURL()).into(lblCountryLocation);

    }



    private class PhotoAdapter extends BaseAdapter {
        private Context mContext;

        public PhotoAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return photos.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {


            if (convertView == null) {
                convertView = getLayoutInflater().inflate(
                        R.layout.cell_photo, null);
            }

            ImageView imgPhoto = (ImageView)convertView.findViewById(R.id.imgPhoto);

            Picasso.with(SpecificLocationActivity.this).
                    load(photos.get(position)).into(imgPhoto);

            return convertView;
        }//end get view


    }//end top image adapter

}
