package com.room.scapez.activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.room.scapez.R;
import com.room.scapez.SearchActivity;


/**
 * Created by snyxius on 9/23/2015.
 */
public class ActivityRooms extends AppCompatActivity implements View.OnClickListener{

    Bundle extras;
    String location;
    TextView locat;
    LinearLayout locationLayout,date1Layout,date2Layout,date3Layout,date4Layout,date5Layout,date6Layout,date7Layout;
    LinearLayout oneLayout,twoLayout,threeLayout,fourLayout,fiveLayout,sixLayout,sevenLayout;
    RelativeLayout dateLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        extras=getIntent().getExtras();

        if(extras.containsKey("location1"))
            location=extras.getString("location1");
        else
            location=extras.getString("location2");

        locat=(TextView)findViewById(R.id.locationName);
        locationLayout=(LinearLayout)findViewById(R.id.locationLayout);
        dateLayout=(RelativeLayout)findViewById(R.id.dateLayout);

        locat.setText(location);
        locationLayout.setOnClickListener(this);
        dateLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.locationLayout:
                Intent cityIntent=new Intent(ActivityRooms.this, SearchActivity.class);
                startActivity(cityIntent);
                break;
            case R.id.dateLayout:
                Dialog dialog  = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.setContentView(R.layout.dialog_layout);
                dialog.setCanceledOnTouchOutside(true);

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();//dialog.getWindow().getAttributes();
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setAttributes(lp);
                dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
//                window.setAttributes(lp);
                lp.dimAmount = 0.50f;
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialog.getWindow().setGravity(android.view.Gravity.TOP);
                lp.gravity = Gravity.TOP;
//                lp.x = -100;   //x position
//                lp.y = -100;   //y position
                dialog.show();


                date1Layout=(LinearLayout)dialog.findViewById(R.id.date1Layout);
                date2Layout=(LinearLayout)dialog.findViewById(R.id.date2Layout);
                date3Layout=(LinearLayout)dialog.findViewById(R.id.date3Layout);
                date4Layout=(LinearLayout)dialog.findViewById(R.id.date4Layout);
                date5Layout=(LinearLayout)dialog.findViewById(R.id.date5Layout);
                date6Layout=(LinearLayout)dialog.findViewById(R.id.date6Layout);
                date7Layout=(LinearLayout)dialog.findViewById(R.id.date7Layout);

                oneLayout=(LinearLayout)dialog.findViewById(R.id.one);
                twoLayout=(LinearLayout)dialog.findViewById(R.id.two);
                threeLayout=(LinearLayout)dialog.findViewById(R.id.three);
                fourLayout=(LinearLayout)dialog.findViewById(R.id.four);
                fiveLayout=(LinearLayout)dialog.findViewById(R.id.five);
                sixLayout=(LinearLayout)dialog.findViewById(R.id.six);
                sevenLayout=(LinearLayout)dialog.findViewById(R.id.seven);
                oneLayout.setOnClickListener(this);
                twoLayout.setOnClickListener(this);
                threeLayout.setOnClickListener(this);
                fourLayout.setOnClickListener(this);
                fiveLayout.setOnClickListener(this);
                sixLayout.setOnClickListener(this);
                sevenLayout.setOnClickListener(this);
                break;

            case R.id.one:
                date1Layout.setBackgroundResource(R.drawable.circle_border);
                date2Layout.setBackgroundResource(0);
                date3Layout.setBackgroundResource(0);
                date4Layout.setBackgroundResource(0);
                date5Layout.setBackgroundResource(0);
                date6Layout.setBackgroundResource(0);
                date7Layout.setBackgroundResource(0);
                animateLayout(oneLayout);
                break;
            case R.id.two:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(R.drawable.circle_border);
                date3Layout.setBackgroundResource(0);
                date4Layout.setBackgroundResource(0);
                date5Layout.setBackgroundResource(0);
                date6Layout.setBackgroundResource(0);
                date7Layout.setBackgroundResource(0);
                animateLayout(twoLayout);
                break;
            case R.id.three:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(0);
                date3Layout.setBackgroundResource(R.drawable.circle_border);
                date4Layout.setBackgroundResource(0);
                date5Layout.setBackgroundResource(0);
                date6Layout.setBackgroundResource(0);
                date7Layout.setBackgroundResource(0);
                animateLayout(threeLayout);
                break;
            case R.id.four:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(0);
                date3Layout.setBackgroundResource(0);
                date4Layout.setBackgroundResource(R.drawable.circle_border);
                date5Layout.setBackgroundResource(0);
                date6Layout.setBackgroundResource(0);
                date7Layout.setBackgroundResource(0);
                animateLayout(fourLayout);
                break;
            case R.id.five:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(0);
                date3Layout.setBackgroundResource(0);
                date4Layout.setBackgroundResource(0);
                date5Layout.setBackgroundResource(R.drawable.circle_border);
                date6Layout.setBackgroundResource(0);
                date7Layout.setBackgroundResource(0);
                animateLayout(fiveLayout);
                break;
            case R.id.six:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(0);
                date3Layout.setBackgroundResource(0);
                date4Layout.setBackgroundResource(0);
                date5Layout.setBackgroundResource(0);
                date6Layout.setBackgroundResource(R.drawable.circle_border);
                date7Layout.setBackgroundResource(0);
                animateLayout(sixLayout);
                break;
            case R.id.seven:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(0);
                date3Layout.setBackgroundResource(0);
                date4Layout.setBackgroundResource(0);
                date5Layout.setBackgroundResource(0);
                date6Layout.setBackgroundResource(0);
                date7Layout.setBackgroundResource(R.drawable.circle_border);
                animateLayout(sevenLayout);
                break;

        }
    }

    private void animateLayout(LinearLayout oneLayout) {
        Animation moveLeft = AnimationUtils.loadAnimation(this, R.anim.translate);
//        TranslateAnimation anim = new TranslateAnimation(0f, -100f, 0f, 0f);  // might need to review the docs
//        anim.setDuration(1000); // set how long you want the animation

        oneLayout.setAnimation(moveLeft);
        oneLayout.setVisibility(View.VISIBLE);
    }


}
