package com.room.scapez.fragments;

/**
 * Created by snyxius on 9/29/2015.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.room.scapez.R;
import com.room.scapez.app.RoomScapez;
import com.room.scapez.pojos.AmenitiesPojo;

import java.util.List;

/**
 * Created by hp1 on 21-01-2015.
 */
public class TabOneFragment extends Fragment {




    public final TabOneFragment newInstance(List<AmenitiesPojo> amenites)
    {
        TabOneFragment f = new TabOneFragment();
//        RoomScapez.saveToPreferences(getActivity().getBaseContext(),"AmenitesArray",amenites);
//        Bundle bdl = new Bundle(2);
//        bdl.putString(TAB_ID, tabId);
//        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_one,container,false);
        return v;
    }
}