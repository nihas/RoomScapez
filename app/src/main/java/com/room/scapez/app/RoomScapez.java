package com.room.scapez.app;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.util.LruCache;
import android.text.TextUtils;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
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
        mRequestQueue = getRequestQueue();

        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            Cache cache = new DiskBasedCache(getApplicationContext().getCacheDir(), 10 * 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            mRequestQueue = new RequestQueue(cache, network);
            // Don't forget to start the volley request queue
            mRequestQueue.start();
        }
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
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
