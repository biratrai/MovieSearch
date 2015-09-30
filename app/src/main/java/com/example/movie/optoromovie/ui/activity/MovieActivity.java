package com.example.movie.optoromovie.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.movie.optoromovie.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mActionDrawerToggle;
    @Bind(R.id.button)
    Button mSearchButton;

    @Bind(R.id.editText)
    EditText mSearchText;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    Animation animRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

         animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        animRotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(getApplication(), MovieListActivity.class);
                intent.putExtra("Movie", mSearchText.getText().toString());
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // Bind all of the view
        ButterKnife.bind(this);

        // Setup Toolbar
        setUpToolbar();

        // Setup NavigationDrawer
//        setupNavigationView();
        setUpHamburger();
    }

    @OnClick(R.id.button)
    public void launchActivity(View view) {
        if (mSearchText.getText().toString().isEmpty()) {
            mSearchText.setError("Movie Search Word not Entered!");
            return;

        } else {
            view.startAnimation(animRotate);

        }
    }

    private void setUpToolbar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }

    private void setUpHamburger() {
        // Set up the hamburger icon to open and close the drawer
        mActionDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mActionDrawerToggle);
        mActionDrawerToggle.syncState();
    }

    private void setupNavigationView() {
        if (mToolbar != null) {
            mToolbar.setNavigationIcon(R.drawable.ic_launcher);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.openDrawer(GravityCompat.START);
//                    Log.d(LOG_TAG, "onClick");
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie, menu);
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
}
