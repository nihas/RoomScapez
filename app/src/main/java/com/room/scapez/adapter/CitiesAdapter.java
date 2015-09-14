package com.room.scapez.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.room.scapez.Person;
import com.room.scapez.R;

import java.util.List;

/**
 * Created by Nihas on 04-Aug-15.
 */
public class CitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // The items to display in your RecyclerView
    private List<Person> items;

    private final int USER = 0, IMAGE = 1;

    // Provide a suitable constructor (depends on the kind of dataset)
    public CitiesAdapter(List<Person> items) {
        this.items = items;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0) {
            return 0;
        } else{
            return 1;
        }
//        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case 0:
                View v1 = inflater.inflate(R.layout.city_single_item_first, viewGroup, false);
                viewHolder = new ViewHolder1(v1);
                break;
            default:
                View v2 = inflater.inflate(R.layout.city_single_item_default, viewGroup, false);
                viewHolder = new ViewHolder2(v2);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case 0:
                ViewHolder1 vh1 = (ViewHolder1) viewHolder;
                configureViewHolder1(vh1, position);
                break;
            default:
                ViewHolder2 vh2 = (ViewHolder2) viewHolder;
                configureViewHolder2(vh2, position);
                break;

        }
    }

    private void configureViewHolder1(ViewHolder1 vh1, int position) {
//        User user = (User) items.get(position);
        vh1.txtViewTitle.setText("Current Location");
        vh1.imgViewIcon.setImageResource(android.R.drawable.ic_menu_compass);
    }

    private void configureViewHolder2(ViewHolder2 vh2, int position) {
        vh2.txtViewTitle.setText(items.get(position).getName());
//        vh2.imgViewIcon.setImageResource(items.get(position).getPhotoId());
    }
}