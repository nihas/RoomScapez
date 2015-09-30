package com.room.scapez.fragments;

/**
 * Created by snyxius on 9/29/2015.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.room.scapez.R;
import com.room.scapez.pojos.AmenitiesPojo;

import java.util.List;

/**
 * Created by hp1 on 21-01-2015.
 */
public class TabThreeFragment extends Fragment {

    static AmenitiesPojo amenitesPojo;
    LinearLayout amenitesLayout;



    public static final TabThreeFragment newInstance(List<AmenitiesPojo> amenites)
    {
        TabThreeFragment f = new TabThreeFragment();
        amenitesPojo=new AmenitiesPojo();
        amenitesPojo.setAmenites(amenites);
//        Bundle bdl = new Bundle(2);
//        bdl.putInt("category", );
//        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_one,container,false);
        amenitesLayout=(LinearLayout)v.findViewById(R.id.amenitesLayout);

        for(int i=0;i<amenitesPojo.getAmenites().size();i++) {
            if(amenitesPojo.getAmenites().get(i).getCategory()==3){
            LinearLayout horiLayout = new LinearLayout(getActivity().getApplicationContext());
            LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            horiLayout.setLayoutParams(lp1);
            horiLayout.setOrientation(LinearLayout.HORIZONTAL);
            horiLayout.setGravity(Gravity.CENTER_VERTICAL);
            horiLayout.setPadding(8, 8, 8, 8);
            amenitesLayout.addView(horiLayout);

            ImageView imageIcon = new ImageView(getActivity().getApplicationContext());
            LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(45, 45);
            imageIcon.setLayoutParams(lp2);
            imageIcon.setImageResource(amenitesPojo.getAmenites().get(i).getImageID());
            horiLayout.addView(imageIcon);

            TextView textv = new TextView(getActivity().getApplicationContext());
            LinearLayout.LayoutParams lp3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            horiLayout.setLayoutParams(lp3);
            textv.setText(amenitesPojo.getAmenites().get(i).getName());
            textv.setPadding(12, 0, 0, 0);
            textv.setTextColor(getResources().getColor(android.R.color.black));
            horiLayout.addView(textv);

        }

        }
        return v;
    }
}