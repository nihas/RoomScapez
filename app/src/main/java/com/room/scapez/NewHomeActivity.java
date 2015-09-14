package com.room.scapez;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nihas on 20-Aug-15.
 */
public class NewHomeActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{

    private CoordinatorLayout mCoordinator;
    //Need this to set the title of the app bar
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    RecyclerView mRecyclerView;
    List<Person> persons;
    TextView myTitle;
    ImageView textBox;
    private ImageView mImageparallax;
    private FrameLayout mFrameParallax;
    private LinearLayout mTitleContainer;
    private LinearLayout mToolbarContainer;

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.6f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;

    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);
        mCoordinator = (CoordinatorLayout) findViewById(R.id.root_coordinator);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        mToolbar.setTitle("");
        mTitleContainer = (LinearLayout) findViewById(R.id.main_linearlayout_title);
        mToolbarContainer=(LinearLayout)findViewById(R.id.newToolBar);
        mAppBarLayout   = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mImageparallax  = (ImageView) findViewById(R.id.main_imageview_placeholder);
        mFrameParallax  = (FrameLayout) findViewById(R.id.main_framelayout_title);
        textBox=(ImageView)findViewById(R.id.searchCity);
        myTitle=(TextView)findViewById(R.id.myTitle);
        startAlphaAnimation(myTitle, 0, View.INVISIBLE);
        mAppBarLayout.addOnOffsetChangedListener(this);
        initParallaxValues();
        textBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIntent=new Intent(NewHomeActivity.this,SearchActivity.class);
                startActivity(searchIntent);
//                overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);

            }
        });


        //Notice how the title is set on the Collapsing Toolbar Layout instead of the Toolbar
//        mCollapsingToolbarLayout.setTitle("RoomScapez");
//        mCollapsingToolbarLayout.setCollapsedTitleTextColor(android.R.color.white);
//        mCollapsingToolbarLayout.setExpandedTitleColor(android.R.color.black);

//        myTitle.setTextSize(22);
        /* Hook a OnOffsetChangedListener to your AppBarLayout.
        When the verticalOffset reaches 0 or leq than Toolbar height,
         means that CollapsingToolbarLayout has collapsed, otherwise it is expanding or expanded.
         */


        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        initializeData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(false);

        MyAdapter adapter = new MyAdapter(persons,this);
        mRecyclerView.setAdapter(adapter);
    }

    public static void startAlphaAnimation (View v, long duration, int visibility) {

        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }

    private void initParallaxValues() {

        CollapsingToolbarLayout.LayoutParams petDetailsLp =
                (CollapsingToolbarLayout.LayoutParams) mImageparallax.getLayoutParams();

        CollapsingToolbarLayout.LayoutParams petBackgroundLp =
                (CollapsingToolbarLayout.LayoutParams) mFrameParallax.getLayoutParams();

        petDetailsLp.setParallaxMultiplier(0.9f);
        petBackgroundLp.setParallaxMultiplier(0.3f);

        mImageparallax.setLayoutParams(petDetailsLp);
        mFrameParallax.setLayoutParams(petBackgroundLp);
    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", "http://im.rediff.com/money/2015/mar/03canvas6.jpg"));
        persons.add(new Person("Lavery Maiss", "25 years old","https://scbeautyhigh.files.wordpress.com/2013/10/154333527.jpg?w=670&h=446"));
        persons.add(new Person("Lillie Watts", "35 years old", "https://s-media-cache-ak0.pinimg.com/736x/ff/3c/32/ff3c32d9f8e9e3282b9912aec3915555.jpg"));
        persons.add(new Person("Emma Wilson", "23 years old", "http://www.herworldplus.com/sites/default/files/Jade%20Seah%20on%20her%20mystery%20engagement%20big%20butts%20and%20the%20perfect%20selfie%20B2.png"));
        persons.add(new Person("Lavery Maiss", "25 years old", "http://1.bp.blogspot.com/-BZl5Ffe2WW4/Tr5DPp7m3LI/AAAAAAAAD7Y/ZI2rYBsG0JA/s1600/vernmark.JPG"));
        persons.add(new Person("Lillie Watts", "35 years old", "http://www.kineo.com/m/0/woody-selfie.jpg"));
        persons.add(new Person("Emma Wilson", "23 years old", "http://selfieyo.com/wp-content/uploads/2015/03/selfiegood1.jpg"));
        persons.add(new Person("Lavery Maiss", "25 years old", "https://fs02.androidpit.info/a/ee/01/selfie-cam-vintage-edition-ee019f-h900.jpg"));
        persons.add(new Person("Lillie Watts", "35 years old", "https://nyoobserver.files.wordpress.com/2015/03/selfie-stick.jpg"));
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(i) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {

        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if(!mIsTheTitleVisible) {
                startAlphaAnimation(myTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
                mToolbarContainer.setBackgroundColor(getResources().getColor(R.color.primary_color));
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(myTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
                mToolbarContainer.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {

        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {

            if(mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
//                mToolbar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
//                mToolbar.setBackgroundColor(getResources().getColor(R.color.primary_color));
            }
        }
    }
}
