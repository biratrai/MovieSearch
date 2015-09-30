package com.example.movie.optoromovie.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movie.optoromovie.MovieBus.OnItemClickEvent;
import com.example.movie.optoromovie.R;
import com.example.movie.optoromovie.domain.model.MovieModel;
import com.example.movie.optoromovie.domain.util.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class MovieDetailActivity extends AppCompatActivity {

        private Toolbar toolbar;
        MovieModel movie;

        @Bind(R.id.movie_description)
        TextView movieDescription;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_movie_detail);
            ButterKnife.bind(this);

            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            // Register to the bus
            EventBus.getDefault().registerSticky(this);

            movieDescription.setText( movie.getOverview());
            CollapsingToolbarLayout collapsingToolbar =
                    (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
            collapsingToolbar.setTitle(movie.getTitle());
            loadBackdrop();

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.detail_fab_button);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

        // onEvent Receive the Event
        public void onEventMainThread(OnItemClickEvent event) {
            movie = (MovieModel) event.bundle.get("movie_data");
        }

        @Override
        public void onStop() {
            EventBus.getDefault().unregister(this);
            super.onStop();
        }

        private void loadBackdrop() {
            final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
            Glide.with(this).load(Constants.BACKDROP_PATH + movie.getBackdropPath()).centerCrop().into(imageView);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case android.R.id.home:
                    Intent homeIntent = new Intent(this, MovieActivity.class);
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(homeIntent);
            }
            return super.onOptionsItemSelected(menuItem);
        }
    }
