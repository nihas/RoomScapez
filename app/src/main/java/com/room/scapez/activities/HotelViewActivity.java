package com.room.scapez.activities;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;
import com.room.scapez.R;
import com.room.scapez.pojos.AmenitiesPojo;

import java.util.ArrayList;

/**
 * Created by snyxius on 9/28/2015.
 */
public class HotelViewActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    Toolbar toolbar;
    String hotelName;
    double latitude,longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_view);
        initializeRecylceView();
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void initializeRecylceView() {
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerView);
//        initializeData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(false);

        HotelDetailsAdapter gymAdapter = new HotelDetailsAdapter(this,hotelName,getAmenitiesList(),latitude,longitude);
        mRecyclerView.setAdapter(gymAdapter);
    }

    private ArrayList<AmenitiesPojo> getAmenitiesList() {
        ArrayList<AmenitiesPojo> list = new ArrayList<>();
        list.add(new AmenitiesPojo("Juice Bar",R.drawable.juice_bar,1));
        list.add(new AmenitiesPojo("Juice Bar",R.drawable.juice_bar,1));
        list.add(new AmenitiesPojo("Juice Bar",R.drawable.juice_bar,1));
        list.add(new AmenitiesPojo("Juice Bar", R.drawable.juice_bar,1));
        list.add(new AmenitiesPojo("Juice Bar", R.drawable.juice_bar,1));
        list.add(new AmenitiesPojo("Juice Bar", R.drawable.juice_bar,1));


        list.add(new AmenitiesPojo("Juice Bar",R.drawable.juice_bar,2));
        list.add(new AmenitiesPojo("Juice Bar",R.drawable.juice_bar,2));
        list.add(new AmenitiesPojo("Juice Bar",R.drawable.juice_bar,2));
        list.add(new AmenitiesPojo("Juice Bar", R.drawable.juice_bar,3));


        return list;
    }
}
