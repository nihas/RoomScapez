package com.room.scapez.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.room.scapez.R;
import com.room.scapez.SearchActivity;

/**
 * Created by snyxius on 9/23/2015.
 */
public class ActivityRooms extends AppCompatActivity implements View.OnClickListener{

    Bundle extras;
    String location;
    TextView locat;
    LinearLayout locationLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        extras=getIntent().getExtras();
        location=extras.getString("location");

        locat=(TextView)findViewById(R.id.locationName);
        locationLayout=(LinearLayout)findViewById(R.id.locationLayout);

        locat.setText(location);
        locationLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.locationLayout:
                Intent cityIntent=new Intent(ActivityRooms.this, SearchActivity.class);
                startActivity(cityIntent);
                break;
        }
    }
}
