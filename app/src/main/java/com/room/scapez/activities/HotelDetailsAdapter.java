package com.room.scapez.activities;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.room.scapez.Person;
import com.room.scapez.R;
import com.room.scapez.adapter.ViewPagerAdapter;
import com.room.scapez.pojos.AmenitiesPojo;
import com.room.scapez.utils.CustomViewPager;
import com.room.scapez.utils.SlidingTabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by snyxius on 9/28/2015.
 */
public class HotelDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

//    List<Information> data= Collections.emptyList();
    private static final int TYPE_HEADER=0;
    private static final int TYPE_ITEM=1;
    private static final int TYPE_MAP=2;
    private LayoutInflater inflater;
    private Context context;
    CharSequence Titles[]={"Hotel","Room","Food"};
    int Numboftabs =3;
    ViewPagerAdapter adapter;



    public HotelDetailsAdapter(Context mcontext, String hotelName, ArrayList<AmenitiesPojo> amenitiesList, double latitude, double longitude) {
        this.context=mcontext;
        inflater=LayoutInflater.from(context);
        adapter=new ViewPagerAdapter(((AppCompatActivity) context).getSupportFragmentManager(),Titles,Numboftabs,amenitiesList);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_HEADER){
            View view=inflater.inflate(R.layout.hotel_detail_header, parent,false);
            HeaderHolder holder=new HeaderHolder(view);
            return holder;
        }
        else if(viewType==TYPE_ITEM){
            View view=inflater.inflate(R.layout.hotel_amenities_item, parent,false);
            ItemHolder holder=new ItemHolder(view);

            return holder;
        }else if(viewType==TYPE_MAP){
            View view=inflater.inflate(R.layout.hotel_detail_footer, parent,false);
            FooterHolder holder=new FooterHolder(view);
            return holder;
        }
        else{
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderHolder ){

        }
        else if(holder instanceof ItemHolder ){



        }else if(holder instanceof FooterHolder ){
            FooterHolder footerHolder=(FooterHolder) holder;


        }

    }



    @Override
    public int getItemCount() {
        return  3;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return TYPE_HEADER;
        }

        else if(position==1){
            return TYPE_ITEM;
        }else{
            return TYPE_MAP;
        }
    }

    class FooterHolder extends RecyclerView.ViewHolder{


        public FooterHolder(View itemView) {
            super(itemView);


        }



    }


    class ItemHolder extends RecyclerView.ViewHolder {
        CustomViewPager pager;
        SlidingTabLayout tabs;

        public ItemHolder(View itemView) {
            super(itemView);
//            category = (TextView) itemView.findViewById(R.id.category);
//            description= (TextView) itemView.findViewById(R.id.description);
            // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
//            adapter =  new ViewPagerAdapter(((HotelViewActivity) context).getSupportFragmentManager(),Titles,Numboftabs);

            // Assigning ViewPager View and setting the adapter
            pager = (CustomViewPager) itemView.findViewById(R.id.pager);


            // Assiging the Sliding Tab Layout View
            tabs = (SlidingTabLayout) itemView.findViewById(R.id.tabs);
            tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

            // Setting Custom Color for the Scroll bar indicator of the Tab View
            tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
                @Override
                public int getIndicatorColor(int position) {
                    return context.getResources().getColor(R.color.md_material_blue_600);
                }
            });
            pager.setAdapter(adapter);
            tabs.setViewPager(pager);



            // Setting the ViewPager For the SlidingTabsLayout

        }
    }

    class HeaderHolder extends RecyclerView.ViewHolder {

        TextView title,moreAmenites;
        ImageView icon;
        LinearLayout amenitesLayout,hori2,hori3;



        public HeaderHolder(View itemView) {
            super(itemView);

        }

    }


}
