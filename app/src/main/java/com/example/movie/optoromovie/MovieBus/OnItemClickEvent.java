package com.example.movie.optoromovie.MovieBus;

import android.os.Bundle;

/**
 * Created by Gooner10 on 8/30/15.
 */
public class OnItemClickEvent {
    public final Bundle bundle;

    public OnItemClickEvent(Bundle bundle) {
        this.bundle = bundle;
    }


    public Bundle getData() {
        return bundle;
    }
}
