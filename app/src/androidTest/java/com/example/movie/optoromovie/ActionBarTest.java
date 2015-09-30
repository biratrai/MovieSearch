package com.example.movie.optoromovie;


import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import com.example.movie.optoromovie.ui.activity.MovieActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ActionBarTest extends ActivityInstrumentationTestCase2<MovieActivity> {

    public ActionBarTest() {
        super(MovieActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickOnMenuItem() {
        // Click on an item from ActionBar
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
//        onView(withId(R.id.action_settings)).perform(click());
        onView(withText(R.string.action_settings)).perform(click());
    }

    public void testOverflowMenuOrOptionsMenu() {
        // Open the action bar overflow or options menu (depending if the device has or not a hardware menu button.)
//        openActionBarOverflowOrOptionsMenu(getInstrumentation().getContext());
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());


        // Find the menu item with text "About" and click on it
        onView(withText("Settings")).perform(click());


        // Verify the correct item was clicked by checking the content of the status TextView
        onView(withId(R.id.action_settings)).check(matches(withText("Settings")));
    }
}
