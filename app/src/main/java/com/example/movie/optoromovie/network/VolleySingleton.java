package com.example.movie.optoromovie.network;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.movie.optoromovie.extras.MyApplication;

public class VolleySingleton {

    private static VolleySingleton sInstance;

    private static RequestQueue mRequestQueue;

    private VolleySingleton() {
        mRequestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }

    public static VolleySingleton getInstance() {
        if (sInstance == null) {
            sInstance = new VolleySingleton();
        }

        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}

