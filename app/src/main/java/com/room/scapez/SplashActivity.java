package com.room.scapez;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.room.scapez.app.RoomScapez;


public class SplashActivity extends ActionBarActivity implements LocationListener{

    private static final int SPLASH_TIME_OUT = 3000;
    ConnectionDetector connection;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    AppLocationService appLocationService;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,
                        AvatarToolbarSample.class);
//                editor.putString("locality", locationAddress);
//                editor.commit();
                //intent.putExtra("locality",locationAddress);
                SplashActivity.this.finish();
                startActivity(intent);
            }
        }, SPLASH_TIME_OUT);
//        sharedPreferences = getSharedPreferences(
//                RoomScapez.sharedPreferencesName, Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//        editor.commit();
//        appLocationService = new AppLocationService(
//                SplashActivity.this);


    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        connection = new ConnectionDetector(getApplicationContext());
//        if (!connection.isConnectingToInternet()) {
//
//            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    switch (which) {
//                        case DialogInterface.BUTTON_POSITIVE:
//                            SplashActivity.this.finish();
//                            break;
//                        case DialogInterface.BUTTON_NEGATIVE:
//                            break;
//                    }
//                }
//            };
//
//            AlertDialog.Builder builder = new AlertDialog.Builder(
//                    SplashActivity.this);
//            builder.setCancelable(false);
//            builder.setMessage(
//                    "Warning : Seems like you are offline. Please check your Internet Connection")
//                    .setPositiveButton("Close", dialogClickListener)
//                    .show();
//
//        }else{
//
//            if (sharedPreferences.getBoolean("isGetLocat", false)) {
//                new Handler().postDelayed(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        Intent intent = new Intent(SplashActivity.this,
//                                HomeActivity.class);
//                        SplashActivity.this.finish();
//                        startActivity(intent);
//                    }
//                }, SPLASH_TIME_OUT);
//            }else {
//                LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//
//                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//                    Toast.makeText(this, "Waiting for Location..", Toast.LENGTH_SHORT).show();
//                    Location gpsLocation = appLocationService
//                            .getLocation(LocationManager.GPS_PROVIDER);
//                    if (gpsLocation != null) {
//                        double latitude = gpsLocation.getLatitude();
//                        double longitude = gpsLocation.getLongitude();
//                        String result = "Latitude: " + gpsLocation.getLatitude() +
//                                " Longitude: " + gpsLocation.getLongitude();
//                        LocationAddress locationAddress = new LocationAddress();
//                        locationAddress.getAddressFromLocation(latitude, longitude,
//                                getApplicationContext(), new GeocoderHandler());
//
//                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//                    }else{
//                        new Handler().postDelayed(new Runnable() {
//
//                            @Override
//                            public void run() {
////                                Intent intent = new Intent(SplashActivity.this,
////                                        MainActivity.class);
////                                editor.putString("locality",locationAddress);
////                                editor.commit();
////                                //intent.putExtra("locality",locationAddress);
////                                SplashActivity.this.finish();
////                                startActivity(intent);
//                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SplashActivity.this);
//                                alertDialogBuilder.setMessage("Can't access your location. Select city manually?")
//                                        .setCancelable(false)
//                                        .setPositiveButton("Select City",
//                                                new DialogInterface.OnClickListener(){
//                                                    public void onClick(DialogInterface dialog, int id){
//                                                        Intent cityList=new Intent(SplashActivity.this,SearchActivity.class);
//                                                        startActivity(cityList);
//                                                        finish();
//
//                                                    }
//                                                });
//                                AlertDialog alert = alertDialogBuilder.create();
//                                alert.show();
//
//                            }
//                        }, 8000);
//                    }
//
//                } else {
//                    showGPSDisabledAlertToUser();
//                }
//
//            }
//
//        }
//    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            final String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("local");

                    break;
                default:
                    locationAddress = null;
            }
            Toast.makeText(getApplicationContext(),locationAddress,Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this,
                            HomeActivity.class);
                    editor.putString("locality",locationAddress);
                    editor.commit();
                    //intent.putExtra("locality",locationAddress);
                    SplashActivity.this.finish();
                    startActivity(intent);
                }
            }, SPLASH_TIME_OUT);
        }
    }


    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("GPS is disabled in your device. Would you like to enable it?")
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                //finish();
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                            }
                        });
        alertDialogBuilder.setNegativeButton("Select City",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                        //sharedPreferences.getBoolean("isGetLocat", true);
                        //getMyCurrentLocation();
                        //editor.putBoolean("isGetLocat",true);
                       // editor.commit();
                        Intent cityList=new Intent(SplashActivity.this,SearchActivity.class);
                        startActivity(cityList);
                        finish();
                       // finish();

                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
