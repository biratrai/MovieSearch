package com.example.movie.optoromovie.ui.activity;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.movie.optoromovie.R;
import com.example.movie.optoromovie.domain.model.MovieDbModel;
import com.example.movie.optoromovie.domain.model.MovieModel;
import com.example.movie.optoromovie.domain.util.Constants;
import com.example.movie.optoromovie.network.VolleySingleton;
import com.example.movie.optoromovie.ui.adapter.MovieAdapter;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieListActivity extends AppCompatActivity {

    public String LOG_TAG = "MovieListActivity";
    ArrayList<MovieModel> mMovieDataArrayList = new ArrayList<>();

    @Bind(R.id.recyclerViewMovie)
    RecyclerView mMovieRecyclerView;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    MovieAdapter mMovieAdapter;
    MovieDbModel mMovieDbModel;

    String mMovieTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        // Bind all of the view
        ButterKnife.bind(this);

        // Initialize recycler view
        mMovieRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewMovie);
        mMovieRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (savedInstanceState != null) {
            mMovieTitle = savedInstanceState.getString("Movie");
        } else {
            // Receive the intent
            mMovieTitle = getIntent().getStringExtra("Movie");
        }

        // Setup Toolbar
        setUpToolbar();

        // Call to parse the json
        JsonParser();
    }

    private void JsonParser() {

        // Builder for URL
        StringBuilder builder = new StringBuilder();
        builder.append(Constants.BASE_URL).append(mMovieTitle).append(Constants.API_KEY);
        String URL = builder.toString();

        // Getting the Volley Request
        RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJsonResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(LOG_TAG, "" + error.getMessage());
            }
        });
        requestQueue.add(jsObjRequest);
    }

    private void parseJsonResponse(JSONObject response) {

        mMovieDbModel = new Gson().fromJson(String.valueOf(response), MovieDbModel.class);

        for (MovieModel movieModel : mMovieDbModel.getResults()) {
            mMovieDataArrayList.add(movieModel);
        }

        mMovieAdapter = new MovieAdapter(this, mMovieDataArrayList);
        mMovieRecyclerView.setAdapter(mMovieAdapter);
    }

    private void setUpToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_list, menu);
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

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Movie", mMovieTitle);
    }
}
