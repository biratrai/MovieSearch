package com.example.movie.optoromovie;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

import com.example.movie.optoromovie.ui.activity.MovieActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.closeDrawer;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

//@LargeTest
public class NavigationDrawerTest extends ActivityInstrumentationTestCase2<MovieActivity>{

    private static String TAG = NavigationDrawerTest.class.getSimpleName();

    public NavigationDrawerTest() {
        super(MovieActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    @SmallTest
    public void testOpenAndCloseDrawer() {
        // Drawer should not be open to start.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));

        // Open the Drawer
        openDrawer(R.id.drawer_layout);

        // The drawer should now be open.
        onView(withId(R.id.drawer_layout)).check(matches(isOpen()));

        // Close the Drawer
        closeDrawer(R.id.drawer_layout);

        // Drawer should be closed again.
        onView(withId(R.id.drawer_layout)).check(matches(isClosed()));
    }

}
