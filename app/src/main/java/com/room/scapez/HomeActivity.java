package com.room.scapez;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.Places;
//import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.room.scapez.app.RoomScapez;
//import com.room.scapez.fragments.ReviewsFragment;
import com.room.scapez.tabstrip.FragmentPagerItem;
import com.room.scapez.tabstrip.FragmentPagerItemAdapter;
import com.room.scapez.tabstrip.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nihas on 09-Jul-15.
 */
public class HomeActivity extends AppCompatActivity{
    Toolbar toolbar;
    RelativeLayout selectCity;
    TextView selectCityText;
//    RecyclerView recycleview;
//    private GoogleApiClient mGoogleApiClient;
    List<HomeData> per;
    HomeData[] persons;
    ViewPager pager;
    FragmentPagerItemAdapter adapter;
//    Bundle extra;
//    private SharedPreferences sharedPreferences;
//    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("RoomScapez");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));


        pager = (ViewPager) findViewById(R.id.pager);
        ViewGroup tab = (ViewGroup) findViewById(R.id.tab);
//        tab.addView(LayoutInflater.from(this).inflate(R.layout.demo_custom_tab_icons, tab, false));
//        final SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
//
//        final LayoutInflater inflater = LayoutInflater.from(viewPagerTab.getContext());
//        final Resources res = viewPagerTab.getContext().getResources();
//
//        viewPagerTab.setCustomTabView(new SmartTabLayout.TabProvider() {
//            @Override
//            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
//                ImageView icon = (ImageView) inflater.inflate(R.layout.custom_tab_icon, container, false);
//                switch (position) {
//                    case 0:
//                        icon.setImageDrawable(res.getDrawable(R.mipmap.icon_settings));
//                        break;
//                    case 1:
//                        icon.setImageDrawable(res.getDrawable(R.mipmap.icon_reverts));
//                        break;
//                    case 2:
//                        icon.setImageDrawable(res.getDrawable(R.mipmap.icon_hiddle));
//                        break;
//                    case 3:
//                        icon.setImageDrawable(res.getDrawable(R.mipmap.icon_reviews));
//                        break;
//                    case 4:
//                        icon.setImageDrawable(res.getDrawable(R.mipmap.icon_friends));
//                        break;
//                    default:
//                        throw new IllegalStateException("Invalid position: " + position);
//                }
//                return icon;
//            }
//        });
        FragmentPagerItems pages = new FragmentPagerItems(this);
        for (int titleResId : tabs()) {
//            pages.add(FragmentPagerItem.of(getString(titleResId), ReviewsFragment.class));

        }

        adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), pages);

        pager.setAdapter(adapter);

        pager.setCurrentItem(2);
//        viewPagerTab.setViewPager(pager);
//        viewPagerTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Toolbar tool=(Toolbar)findViewById(R.id.toolbar);
//                switch (position) {
//                    case 0:
//                        tool.setTitle("Settings");
////                        showToolbar();
//                        break;
//                    case 1:
//                        tool.setTitle("Reverts");
////                        showToolbar();
//                        break;
//                    case 2:
//                        tool.setTitle("Hiddle");
////                        showToolbar();
//                        break;
//                    case 3:
//                        tool.setTitle("Reviews");
////                        showToolbar();
//                        break;
//                    case 4:
//                        tool.setTitle("Friends");
////                        showToolbar();
//                        break;
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

//        recycleview=(RecyclerView)findViewById(R.id.recyclerView);
//        recycleview.setHasFixedSize(true);
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        recycleview.setLayoutManager(llm);

        HomeData per[] = { //new ArrayList<>();

                new HomeData("Bangalore", "23 years old", R.drawable.first),
                new HomeData("Delhi", "25 years old", R.drawable.first),
                new HomeData("Ludhiana", "35 years old", R.drawable.first),
                new HomeData("Ernakulam", "23 years old", R.drawable.first),
                new HomeData("Alappuzha", "25 years old", R.drawable.first),
                new HomeData("Trivandrum", "35 years old", R.drawable.first),
                new HomeData("Kottayam", "23 years old", R.drawable.first),
                new HomeData("Idukki", "25 years old", R.drawable.first),
                new HomeData("Moonnar", "35 years old", R.drawable.first),
                new HomeData("Kumily", "23 years old", R.drawable.first),
                new HomeData("Thrissur", "25 years old", R.drawable.first),
                new HomeData("Hyderabad", "35 years old", R.drawable.first),
                new HomeData("Kollam", "23 years old", R.drawable.first),
                new HomeData("Goa", "25 years old", R.drawable.first),
                new HomeData("Kasargod", "35 years old", R.drawable.first),
                new HomeData("Kanyakumari", "23 years old", R.drawable.first),
                new HomeData("Rajasthan", "25 years old", R.drawable.first),
                new HomeData("Wayanad", "35 years old", R.drawable.first),
                new HomeData("Palakad", "23 years old", R.drawable.first),
                new HomeData("Salem", "25 years old", R.drawable.first),
                new HomeData("Chennai", "35 years old", R.drawable.first),
                new HomeData("Madhurai", "23 years old", R.drawable.first),
                new HomeData("Andhra Pradesh", "25 years old", R.drawable.first),
                new HomeData("Kochi", "35 years old", R.drawable.first)
        };

//        final MyAdapter adapter = new MyAdapter(per);
//        recycleview.setAdapter(adapter);

//        mGoogleApiClient = new GoogleApiClient
//                .Builder(this)
//                .addApi(Places.GEO_DATA_API)
//                .addApi(Places.PLACE_DETECTION_API)
//               // .addConnectionCallbacks(this)
//                //.addOnConnectionFailedListener(this)
//                .build();
//        sharedPreferences = getSharedPreferences(
//                RoomScapez.sharedPreferencesName, Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//        editor.commit();
        //ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        //pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

//        PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi
//                .getCurrentPlace(mGoogleApiClient, null);
//        result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
//            @Override
//            public void onResult(PlaceLikelihoodBuffer likelyPlaces) {
//                for (PlaceLikelihood placeLikelihood : likelyPlaces) {
//                    Log.i("PLACE", String.format("Place '%s' has likelihood: %g",
//                            placeLikelihood.getPlace().getName(),
//                            placeLikelihood.getLikelihood()));
//                }
//                likelyPlaces.release();
//            }
//        });

        selectCity=(RelativeLayout)findViewById(R.id.selectCity);
        selectCityText=(TextView)findViewById(R.id.selectCityText);
//        if(sharedPreferences.getBoolean("isGetLocat",true)){
//            selectCityText.setText(sharedPreferences.getString("selectedCity",""));
//        }else {
//            extra = getIntent().getExtras();
//            if (extra != null) {
//                String citySelect = extra.getString("city");
//                // if (citySelect != null) {
//                selectCityText.setText(citySelect);
//                //sharedPreferences.putBoolean("isGetLocat", false);
//                editor = sharedPreferences.edit();
//                editor.putBoolean("isGetLocat", true);
//                editor.putString("locality",citySelect);
//                editor.apply();
//            } else {
//                if(sharedPreferences.getBoolean("isGetLocat",true)) {
//                    selectCityText.setText(sharedPreferences.getString("locality",""));
//                }else{
//                    selectCityText.setText("Select City");
//                }
//            }
//        }
//        selectCity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //showLongList();
//                Intent searchView=new Intent(HomeActivity.this,SearchActivity.class);
//                startActivity(searchView);
//                finish();
//            }
//        });

    }

    public int[] tabs() {
        return new int[] {
                R.string.app_name,
                R.string.app_name,
                R.string.app_name,
                R.string.app_name,
                R.string.app_name
        };
    }

    private void showLongList() {
        new MaterialDialog.Builder(this)
                .title("Cities")
                .items(R.array.states)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        //Toast.makeText(HomeActivity.this, text, Toast.LENGTH_SHORT);
                        selectCityText.setText(text);
                    }
                })
                .positiveText(android.R.string.cancel)
                .show();
    }

    private void initializeData() {




    }


    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return FirstFragment.newInstance("Last Minute Booking.");
                case 1: return FirstFragment.newInstance("Third Gender Integration.");
                case 2: return FirstFragment.newInstance("Find Rooms Quickly");
                default: return FirstFragment.newInstance("Hiiiiiiiiiiiiii");
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
