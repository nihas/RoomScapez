package com.room.scapez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.room.scapez.app.RoomScapez;

public class AvatarToolbarSample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_toolbar_sample);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        TextView title=(TextView)findViewById(R.id.cat_title);
        ImageView search=(ImageView)findViewById(R.id.searchCity);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent=new Intent(AvatarToolbarSample.this,SearchActivity.class);
                startActivity(searchIntent);
            }
        });
//title.setTypeface(RoomScapez.font_regular);
//        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    }
}
