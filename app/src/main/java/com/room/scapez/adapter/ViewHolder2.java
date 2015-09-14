package com.room.scapez.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.room.scapez.R;

/**
 * Created by Nihas on 04-Aug-15.
 */
public class ViewHolder2 extends RecyclerView.ViewHolder {

    public TextView txtViewTitle;
    public ImageView imgViewIcon;

    public ViewHolder2(View v) {
        super(v);
        txtViewTitle = (TextView) v.findViewById(R.id.item_title);
        imgViewIcon = (ImageView) v.findViewById(R.id.item_icon);
    }

    public TextView getTxtViewTitle() {
        return txtViewTitle;
    }

    public void setTxtViewTitle(TextView txtViewTitle) {
        this.txtViewTitle = txtViewTitle;
    }

    public ImageView getImgViewIcon() {
        return imgViewIcon;
    }

    public void setImgViewIcon(ImageView imgViewIcon) {
        this.imgViewIcon = imgViewIcon;
    }
}