package com.room.scapez;

/**
 * Created by Nihas on 01-Aug-15.
 */
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.room.scapez.app.BitmapCache;
import com.room.scapez.app.RoomScapez;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Person> itemsData;
    private RequestQueue mQueue;
    private ImageLoader imageLoader;
    Context mContext;

    public MyAdapter(List<Person> itemsData, Context context) {
        this.itemsData = itemsData;
//        mQueue = Volley.newRequestQueue(context);
        imageLoader = RoomScapez.getInstance().getImageLoader();
        this.mContext=context;
//        imageLoader = new ImageLoader(mQueue, new BitmapCache());
//        setHasStableIds(true);

    }



    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_single_item, null);

        // create ViewHolder


        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.txtViewTitle.setText(itemsData.get(position).getName());
        //viewHolder.imgViewIcon.setImageResource(itemsData.get(position).getPhotoId());
        imageLoader.get(itemsData.get(position).photoId, ImageLoader.getImageListener(viewHolder.imgViewIcon,
                R.drawable.first, R.drawable.pattern));
        viewHolder.imgViewIcon.setImageUrl(itemsData.get(position).photoId, imageLoader);
//        viewHolder.imgViewIcon.setImageUrl(itemsData.get(position).photoId, imageLoader);
//        viewHolder.imgViewIcon.setDefaultImageResId(R.drawable.first);



    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewTitle;
        public NetworkImageView imgViewIcon;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (NetworkImageView) itemLayoutView.findViewById(R.id.item_icon);
        }
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.size();
    }
}