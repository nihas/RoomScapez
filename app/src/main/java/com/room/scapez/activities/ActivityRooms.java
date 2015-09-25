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
import com.room.scapez.pojos.CheckinCheckout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * Created by snyxius on 9/23/2015.
 */
public class ActivityRooms extends AppCompatActivity implements View.OnClickListener{

    Bundle extras;
    String location;
    TextView locat;
    LinearLayout locationLayout,date1Layout,date2Layout,date3Layout,date4Layout,date5Layout,date6Layout,date7Layout;
    LinearLayout oneLayout,twoLayout,threeLayout,fourLayout,fiveLayout,sixLayout,sevenLayout;
    LinearLayout checkinLayout,checkoutLayout;
    TextView week1,week2,week3,week4,week5,week6,week7;
    TextView dates1,dates2,dates3,dates4,dates5,dates6,dates7;
    TextView checkoutWeek1,checkoutWeek2,checkoutWeek3,checkoutWeek4,checkoutWeek5,checkinWeek;
    TextView checkoutdates1,checkoutdates2,checkoutdates3,checkoutdates4,checkoutdates5,checkinDate;
    RelativeLayout dateLayout;
    Calendar localCalendar;
    CheckinCheckout checkinCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        extras=getIntent().getExtras();
        checkinCheckout=new CheckinCheckout();

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

                localCalendar = Calendar.getInstance(TimeZone.getDefault());

                Date currentTime = localCalendar.getTime();
                int currentDay = localCalendar.get(Calendar.DATE);
                int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
                int currentYear = localCalendar.get(Calendar.YEAR);
                int currentDayOfWeek = localCalendar.get(Calendar.DAY_OF_WEEK);
                int currentDayOfMonth = localCalendar.get(Calendar.DAY_OF_MONTH);
                int CurrentDayOfYear = localCalendar.get(Calendar.DAY_OF_YEAR);

                System.out.println("Current Date and time details in local timezone");
                System.out.println("Current Date: " + currentTime);
                System.out.println("Current Day: " + currentDay);
                System.out.println("Current Month: " + currentMonth);
                System.out.println("Current Year: " + currentYear);
                System.out.println("Current Day of Week: " + currentDayOfWeek);
                System.out.println("Current Day of Month: " + currentDayOfMonth);
                System.out.println("Current Day of Year: " + CurrentDayOfYear);

                checkinLayout=(LinearLayout)dialog.findViewById(R.id.checkinLayout);
                checkoutLayout=(LinearLayout)dialog.findViewById(R.id.checkoutLayout);
                checkoutLayout.setVisibility(View.GONE);

                week1=(TextView)dialog.findViewById(R.id.week1);
                week2=(TextView)dialog.findViewById(R.id.week2);
                week3=(TextView)dialog.findViewById(R.id.week3);
                week4=(TextView)dialog.findViewById(R.id.week4);
                week5=(TextView)dialog.findViewById(R.id.week5);
                week6=(TextView)dialog.findViewById(R.id.week6);
                week7=(TextView)dialog.findViewById(R.id.week7);

                setWeekNames(currentDayOfWeek);

                dates1=(TextView)dialog.findViewById(R.id.date1);
                dates2=(TextView)dialog.findViewById(R.id.date2);
                dates3=(TextView)dialog.findViewById(R.id.date3);
                dates4=(TextView)dialog.findViewById(R.id.date4);
                dates5=(TextView)dialog.findViewById(R.id.date5);
                dates6=(TextView)dialog.findViewById(R.id.date6);
                dates7=(TextView)dialog.findViewById(R.id.date7);

                setDates(currentDay);

                date1Layout=(LinearLayout)dialog.findViewById(R.id.date1Layout);
                date2Layout=(LinearLayout)dialog.findViewById(R.id.date2Layout);
                date3Layout=(LinearLayout)dialog.findViewById(R.id.date3Layout);
                date4Layout=(LinearLayout)dialog.findViewById(R.id.date4Layout);
                date5Layout=(LinearLayout)dialog.findViewById(R.id.date5Layout);
                date6Layout=(LinearLayout)dialog.findViewById(R.id.date6Layout);
                date7Layout=(LinearLayout)dialog.findViewById(R.id.date7Layout);

                checkinWeek=(TextView)dialog.findViewById(R.id.checkinWeek);
                checkoutWeek1=(TextView)dialog.findViewById(R.id.checkOutWeek1);
                checkoutWeek2=(TextView)dialog.findViewById(R.id.checkOutWeek2);
                checkoutWeek3=(TextView)dialog.findViewById(R.id.checkOutWeek3);
                checkoutWeek4=(TextView)dialog.findViewById(R.id.checkOutWeek4);
                checkoutWeek5=(TextView)dialog.findViewById(R.id.checkOutWeek5);

                checkinDate=(TextView)dialog.findViewById(R.id.checkindate);
                checkoutdates1=(TextView)dialog.findViewById(R.id.checkOutdate1);
                checkoutdates2=(TextView)dialog.findViewById(R.id.checkOutdate2);
                checkoutdates3=(TextView)dialog.findViewById(R.id.checkOutdate3);
                checkoutdates4=(TextView)dialog.findViewById(R.id.checkOutdate4);
                checkoutdates5=(TextView)dialog.findViewById(R.id.checkOutdate5);

                oneLayout=(LinearLayout)dialog.findViewById(R.id.one);
                twoLayout=(LinearLayout)dialog.findViewById(R.id.two);
                threeLayout=(LinearLayout)dialog.findViewById(R.id.three);
                fourLayout=(LinearLayout)dialog.findViewById(R.id.four);
                fiveLayout=(LinearLayout)dialog.findViewById(R.id.five);
                sixLayout=(LinearLayout)dialog.findViewById(R.id.six);
                sevenLayout=(LinearLayout)dialog.findViewById(R.id.seven);
                makeEvrythingVisible();
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
                animateLayout(oneLayout, twoLayout, threeLayout, fourLayout, fiveLayout, sixLayout, sevenLayout);
                checkinCheckout.setCheckinDate(Integer.valueOf(dates1.getText().toString()));
                checkinCheckout.setCheckinMonth(getMonthName(localCalendar.get(Calendar.MONTH) + 1));
                checkinCheckout.setCheckinWeek(week1.getText().toString());
                checkinCheckout.setCheckinYear(localCalendar.get(Calendar.YEAR));
                break;
            case R.id.two:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(R.drawable.circle_border);
                date3Layout.setBackgroundResource(0);
                date4Layout.setBackgroundResource(0);
                date5Layout.setBackgroundResource(0);
                date6Layout.setBackgroundResource(0);
                date7Layout.setBackgroundResource(0);
                animateLayout(twoLayout, oneLayout, threeLayout, fourLayout, fiveLayout, sixLayout, sevenLayout);
                checkinCheckout.setCheckinDate(Integer.valueOf(dates2.getText().toString()));
                checkinCheckout.setCheckinMonth(getMonthName(localCalendar.get(Calendar.MONTH) + 1));
                checkinCheckout.setCheckinWeek(week2.getText().toString());
                checkinCheckout.setCheckinYear(localCalendar.get(Calendar.YEAR));
                break;
            case R.id.three:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(0);
                date3Layout.setBackgroundResource(R.drawable.circle_border);
                date4Layout.setBackgroundResource(0);
                date5Layout.setBackgroundResource(0);
                date6Layout.setBackgroundResource(0);
                date7Layout.setBackgroundResource(0);
                animateLayout(threeLayout, oneLayout, twoLayout, fourLayout, fiveLayout, sixLayout, sevenLayout);
                checkinCheckout.setCheckinDate(Integer.valueOf(dates3.getText().toString()));
                checkinCheckout.setCheckinMonth(getMonthName(localCalendar.get(Calendar.MONTH) + 1));
                checkinCheckout.setCheckinWeek(week3.getText().toString());
                checkinCheckout.setCheckinYear(localCalendar.get(Calendar.YEAR));
                break;
            case R.id.four:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(0);
                date3Layout.setBackgroundResource(0);
                date4Layout.setBackgroundResource(R.drawable.circle_border);
                date5Layout.setBackgroundResource(0);
                date6Layout.setBackgroundResource(0);
                date7Layout.setBackgroundResource(0);
                animateLayout(fourLayout, oneLayout, twoLayout, threeLayout, fiveLayout, sixLayout, sevenLayout);
                checkinCheckout.setCheckinDate(Integer.valueOf(dates4.getText().toString()));
                checkinCheckout.setCheckinMonth(getMonthName(localCalendar.get(Calendar.MONTH) + 1));
                checkinCheckout.setCheckinWeek(week4.getText().toString());
                checkinCheckout.setCheckinYear(localCalendar.get(Calendar.YEAR));
                break;
            case R.id.five:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(0);
                date3Layout.setBackgroundResource(0);
                date4Layout.setBackgroundResource(0);
                date5Layout.setBackgroundResource(R.drawable.circle_border);
                date6Layout.setBackgroundResource(0);
                date7Layout.setBackgroundResource(0);
                animateLayout(fiveLayout, oneLayout, twoLayout, threeLayout, fourLayout, sixLayout, sevenLayout);
                checkinCheckout.setCheckinDate(Integer.valueOf(dates5.getText().toString()));
                checkinCheckout.setCheckinMonth(getMonthName(localCalendar.get(Calendar.MONTH) + 1));
                checkinCheckout.setCheckinWeek(week5.getText().toString());
                checkinCheckout.setCheckinYear(localCalendar.get(Calendar.YEAR));
                break;
            case R.id.six:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(0);
                date3Layout.setBackgroundResource(0);
                date4Layout.setBackgroundResource(0);
                date5Layout.setBackgroundResource(0);
                date6Layout.setBackgroundResource(R.drawable.circle_border);
                date7Layout.setBackgroundResource(0);
                animateLayout(sixLayout, oneLayout, twoLayout, threeLayout, fourLayout, fiveLayout, sevenLayout);
                checkinCheckout.setCheckinDate(Integer.valueOf(dates6.getText().toString()));
                checkinCheckout.setCheckinMonth(getMonthName(localCalendar.get(Calendar.MONTH) + 1));
                checkinCheckout.setCheckinWeek(week6.getText().toString());
                checkinCheckout.setCheckinYear(localCalendar.get(Calendar.YEAR));
                break;
            case R.id.seven:
                date1Layout.setBackgroundResource(0);
                date2Layout.setBackgroundResource(0);
                date3Layout.setBackgroundResource(0);
                date4Layout.setBackgroundResource(0);
                date5Layout.setBackgroundResource(0);
                date6Layout.setBackgroundResource(0);
                date7Layout.setBackgroundResource(R.drawable.circle_border);
                animateLayout(sevenLayout, oneLayout, twoLayout, threeLayout, fourLayout, fiveLayout, sixLayout);
                checkinCheckout.setCheckinDate(Integer.valueOf(dates7.getText().toString()));
                checkinCheckout.setCheckinMonth(getMonthName(localCalendar.get(Calendar.MONTH) + 1));
                checkinCheckout.setCheckinWeek(week7.getText().toString());
                checkinCheckout.setCheckinYear(localCalendar.get(Calendar.YEAR));
                break;

        }
    }

    private void setDates(int currentDay) {
        if(currentDay>0 && currentDay<=9)
            dates1.setText("0"+Integer.toString(currentDay));
        else
            dates1.setText(Integer.toString(currentDay));

        Calendar cal = Calendar.getInstance(TimeZone.getDefault());

        cal.add(Calendar.DATE, 1);
        if(cal.get(Calendar.DATE)>0 && cal.get(Calendar.DATE)<=9)
            dates2.setText("0"+Integer.toString(cal.get(Calendar.DATE)));
        else
            dates2.setText(Integer.toString(cal.get(Calendar.DATE)));

        cal.add(Calendar.DATE, 1);
        if(cal.get(Calendar.DATE)>0 && cal.get(Calendar.DATE)<=9)
            dates3.setText("0"+Integer.toString(cal.get(Calendar.DATE)));
        else
            dates3.setText(Integer.toString(cal.get(Calendar.DATE)));

        cal.add(Calendar.DATE, 1);
        if(cal.get(Calendar.DATE)>0 && cal.get(Calendar.DATE)<=9)
            dates4.setText("0"+Integer.toString(cal.get(Calendar.DATE)));
        else
            dates4.setText(Integer.toString(cal.get(Calendar.DATE)));

        cal.add(Calendar.DATE, 1);
        if(cal.get(Calendar.DATE)>0 && cal.get(Calendar.DATE)<=9)
            dates5.setText("0"+Integer.toString(cal.get(Calendar.DATE)));
        else
            dates5.setText(Integer.toString(cal.get(Calendar.DATE)));

        cal.add(Calendar.DATE, 1);
        if(cal.get(Calendar.DATE)>0 && cal.get(Calendar.DATE)<=9)
            dates6.setText("0"+Integer.toString(cal.get(Calendar.DATE)));
        else
            dates6.setText(Integer.toString(cal.get(Calendar.DATE)));

        cal.add(Calendar.DATE, 1);
        if(cal.get(Calendar.DATE)>0 && cal.get(Calendar.DATE)<=9)
            dates7.setText("0"+Integer.toString(cal.get(Calendar.DATE)));
        else
            dates7.setText(Integer.toString(cal.get(Calendar.DATE)));
    }

    private void setWeekNames(int currentDayOfWeek) {
        switch (currentDayOfWeek){
            case 1:
                week1.setText("SUN");
                week2.setText("MON");
                week3.setText("TUE");
                week4.setText("WED");
                week5.setText("THU");
                week6.setText("FRI");
                week7.setText("SAT");
                break;
            case 2:
                week1.setText("MON");
                week2.setText("TUE");
                week3.setText("WED");
                week4.setText("THU");
                week5.setText("FRI");
                week6.setText("SAT");
                week7.setText("SUN");
                break;
            case 3:
                week1.setText("TUE");
                week2.setText("WED");
                week3.setText("THU");
                week4.setText("FRI");
                week5.setText("SAT");
                week6.setText("SUN");
                week7.setText("MON");
                break;
            case 4:
                week1.setText("WED");
                week2.setText("THU");
                week3.setText("FRI");
                week4.setText("SAT");
                week5.setText("SUN");
                week6.setText("MON");
                week7.setText("TUE");
                break;
            case 5:
                week1.setText("THU");
                week2.setText("FRI");
                week3.setText("SAT");
                week4.setText("SUN");
                week5.setText("SAT");
                week6.setText("MON");
                week7.setText("TUE");
                break;
            case 6:
                week1.setText("FRI");
                week2.setText("SAT");
                week3.setText("SUN");
                week4.setText("MON");
                week5.setText("TUE");
                week6.setText("WED");
                week7.setText("THU");
                break;
            case 7:
                week1.setText("SAT");
                week2.setText("SUN");
                week3.setText("MON");
                week4.setText("TUE");
                week5.setText("WED");
                week6.setText("THU");
                week7.setText("FRI");
                break;
        }
    }

    private void animateLayout(LinearLayout clicked,LinearLayout one,LinearLayout two,LinearLayout three,LinearLayout four,
                               LinearLayout five,LinearLayout six) {
//        Animation moveLeft = AnimationUtils.loadAnimation(this, R.anim.translate);
        TranslateAnimation anim = new TranslateAnimation(0f, 0f, 0f, -100f);  // might need to review the docs
        anim.setStartOffset(100);
        anim.setDuration(500); // set how long you want the animation

        clicked.setAnimation(anim);
        clicked.setVisibility(View.VISIBLE);

        one.setVisibility(View.INVISIBLE);
        two.setVisibility(View.INVISIBLE);
        three.setVisibility(View.INVISIBLE);
        four.setVisibility(View.INVISIBLE);
        five.setVisibility(View.INVISIBLE);
        six.setVisibility(View.INVISIBLE);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                checkinLayout.setVisibility(View.GONE);
                checkoutLayout.setVisibility(View.VISIBLE);
                checkinWeek.setText(checkinCheckout.getCheckinWeek());
                checkinDate.setText(String.valueOf(checkinCheckout.getCheckinDate()));
                makeEvrythingVisible();
                TranslateAnimation anim = new TranslateAnimation(0f, 0f, -110f, 0f);  // might need to review the docs
                anim.setDuration(500);
                Calendar myCal=Calendar.getInstance(TimeZone.getDefault());
                SimpleDateFormat format = new SimpleDateFormat("MMM dd,yyyy", Locale.ENGLISH);
                try {
                    Date theDate = format.parse(checkinCheckout.getCheckinMonth()+" "+checkinCheckout.getCheckinDate()+","+checkinCheckout.getCheckinYear());//+JAN 13,2014");
                    myCal.setTime(theDate);
                    myCal.add(Calendar.DATE, 1);
                    checkoutWeek1.setText(getWeekName(myCal.get(Calendar.DAY_OF_WEEK)));
                    checkoutdates1.setText(String.valueOf(myCal.get(Calendar.DATE)));
                    myCal.add(Calendar.DATE, 1);
                    checkoutWeek2.setText(getWeekName(myCal.get(Calendar.DAY_OF_WEEK)));
                    checkoutdates2.setText(String.valueOf(myCal.get(Calendar.DATE)));
                    myCal.add(Calendar.DATE, 1);
                    checkoutWeek3.setText(getWeekName(myCal.get(Calendar.DAY_OF_WEEK)));
                    checkoutdates3.setText(String.valueOf(myCal.get(Calendar.DATE)));
                    myCal.add(Calendar.DATE, 1);
                    checkoutWeek4.setText(getWeekName(myCal.get(Calendar.DAY_OF_WEEK)));
                    checkoutdates4.setText(String.valueOf(myCal.get(Calendar.DATE)));
                    myCal.add(Calendar.DATE, 1);
                    checkoutWeek5.setText(getWeekName(myCal.get(Calendar.DAY_OF_WEEK)));
                    checkoutdates5.setText(String.valueOf(myCal.get(Calendar.DATE)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                checkoutLayout.setAnimation(anim);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public String getWeekName(int weekNo){
        switch (weekNo){
            case 1: return "SUN";
            case 2: return "MON";
            case 3: return "TUE";
            case 4: return "WED";
            case 5: return "THU";
            case 6: return "FRI";
            case 7: return "SAT";
        }
        return "Null";
    }

    public String getMonthName(int monthNo){
        switch (monthNo){
            case 1: return "JAN";case 2: return "FEB";case 3: return "MAR";case 4: return "APR";case 5: return "MAY";
            case 6: return "JUN";case 7: return "JUL";case 8: return "AUG";case 9: return "SEP";case 10: return "OCT";
            case 11: return "NOV";case 12: return "DEC";

        }
        return "Null";
    }

    public void makeEvrythingInvisible(){
        oneLayout.setVisibility(View.INVISIBLE);
        twoLayout.setVisibility(View.INVISIBLE);
        threeLayout.setVisibility(View.INVISIBLE);
        fourLayout.setVisibility(View.INVISIBLE);
        fiveLayout.setVisibility(View.INVISIBLE);
        sixLayout.setVisibility(View.INVISIBLE);
        sevenLayout.setVisibility(View.INVISIBLE);

    }

    public void makeEvrythingVisible(){
        oneLayout.setVisibility(View.VISIBLE);
        twoLayout.setVisibility(View.VISIBLE);
        threeLayout.setVisibility(View.VISIBLE);
        fourLayout.setVisibility(View.VISIBLE);
        fiveLayout.setVisibility(View.VISIBLE);
        sixLayout.setVisibility(View.VISIBLE);
        sevenLayout.setVisibility(View.VISIBLE);

    }


}
