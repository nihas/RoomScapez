package com.room.scapez.app;

import android.app.Application;
import android.content.ContentResolver;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.io.File;
import java.io.IOException;

/**
 * Created by Nihas on 25-Jul-15.
 */
public class RoomScapez extends Application {

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    public static final String TAG = RoomScapez.class.getSimpleName();
    public static Typeface font_regular,font_bold,font_hiddle,font_hiddle_bold;

    private static RoomScapez mInstance;

    public static String sharedPreferencesName = "RoomScapez";

    public static synchronized RoomScapez getInstance() {
        return mInstance;
    }

    public void onCreate() {
        super.onCreate();
//        context = this;
        mInstance=this;
        font_regular=Typeface.createFromAsset(getAssets(),"AGENCYR.TTF");
//        font_hiddle=Typeface.createFromAsset(getAssets(),"fonts/eurof35.ttf");
//        font_hiddle_bold=Typeface.createFromAsset(getAssets(),"fonts/eurof75.ttf");
//        font_bold=Typeface.createFromAsset(getAssets(),"fonts/AGENCYB.TTF");//eurof75.ttf");
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new BitmapCache());
        }
        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    public static void deleteFileFromMediaStore(final ContentResolver contentResolver, final File file) {
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (IOException e) {
            canonicalPath = file.getAbsolutePath();
        }
        final Uri uri = MediaStore.Files.getContentUri("external");
        final int result = contentResolver.delete(uri,
                MediaStore.Files.FileColumns.DATA + "=?", new String[] {canonicalPath});
        if (result == 0) {
            final String absolutePath = file.getAbsolutePath();
            if (!absolutePath.equals(canonicalPath)) {
                contentResolver.delete(uri,
                        MediaStore.Files.FileColumns.DATA + "=?", new String[]{absolutePath});
            }
        }
    }
}
