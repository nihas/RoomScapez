package com.room.scapez;

/**
 * Created by Nihas on 01-Aug-15.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    private List<Person> itemsData;

    public CityAdapter(List<Person> itemsData) {
        this.itemsData = itemsData;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    // Create new views (invoked by the layout manager)
    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        ViewHolder generalViewHolder;
        View itemLayoutView;


            // create a new view
            itemLayoutView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.city_single_item_default, null);
            generalViewHolder = new ViewHolder(itemLayoutView);


        // create ViewHolder

//        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
//        ViewHolder viewHolder2 = new ViewHolder(itemLayoutView1);
//        if(viewType==0){
//            return viewHolder2;
//        }else {
            return generalViewHolder;
//        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

    viewHolder.txtViewTitle.setText(itemsData.get(position).getName());
//    viewHolder.imgViewIcon.setImageResource(itemsData.get(position).getPhotoId());



    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public ImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
        }
    }



    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.size();
    }
}