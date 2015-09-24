package com.room.scapez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.room.scapez.activities.ActivityRooms;
import com.room.scapez.app.RoomScapez;
import com.room.scapez.utils.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class AvatarToolbarSample extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_toolbar_sample);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        TextView title = (TextView) findViewById(R.id.cat_title);
        title.setTypeface(RoomScapez.font_regular);
        ImageView search = (ImageView) findViewById(R.id.searchCity);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent = new Intent(AvatarToolbarSample.this, SearchActivity.class);
                startActivity(searchIntent);
                overridePendingTransition(R.anim.push_up_in, R.anim.fade_out);
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initializeData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(false);

        MyAdapter adapter = new MyAdapter(persons, this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent roomIntent=new Intent(AvatarToolbarSample.this, ActivityRooms.class);
                        roomIntent.putExtra("location1",persons.get(position).getName());
                        startActivity(roomIntent);
                        finish();
                    }
                }));
//title.setTypeface(RoomScapez.font_regular);
//        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_mtrl_am_alpha);


}

    private void initializeData() {
        persons = new ArrayList<>();
        persons.add(new Person("Bangalore", "23 years old", "http://socialventurepartners.org.s3.amazonaws.com/www.socialventurepartners.org/sites/58/2013/05/Bangalore-slider.jpg"));
        persons.add(new Person("Delhi", "25 years old", "http://wallpapersearchengine.com/wp-content/uploads/2015/06/Delhi-Wallpapers-1.jpg"));
        persons.add(new Person("Hyderabad", "35 years old", "http://3.bp.blogspot.com/-Ub8csjGTQao/Uih5Xe4ZQxI/AAAAAAAApPQ/gb2QH0H0ndo/s1600/Hyderabad+1080p+Wallpapers+2.jpg"));
        persons.add(new Person("Kochi", "23 years old", "http://www.k.guruvayur4u.com/images/kumb6.jpg"));
        persons.add(new Person("Munnar", "25 years old", "http://welcomenri.com/Tourism/Honeymoon/south-india-honeymoon/munnar.jpg"));
        persons.add(new Person("Thekady", "35 years old", "http://farm3.static.flickr.com/2795/4181596499_3e4998d663_b.jpg"));
//        persons.add(new Person("Emma Wilson", "23 years old", "http://selfieyo.com/wp-content/uploads/2015/03/selfiegood1.jpg"));
//        persons.add(new Person("Lavery Maiss", "25 years old", "https://fs02.androidpit.info/a/ee/01/selfie-cam-vintage-edition-ee019f-h900.jpg"));
//        persons.add(new Person("Lillie Watts", "35 years old", "https://nyoobserver.files.wordpress.com/2015/03/selfie-stick.jpg"));
    }
}
