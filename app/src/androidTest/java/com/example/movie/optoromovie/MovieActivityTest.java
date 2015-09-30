package com.example.movie.optoromovie;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.movie.optoromovie.ui.activity.MovieActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MovieActivityTest {
    public static final String STRING_TO_BE_TYPED = "fight";
    @Rule
    public ActivityTestRule<MovieActivity> mActivityRule = new ActivityTestRule<>(
            MovieActivity.class);

    @Test
    public void shouldDisplayHintText(){
        onView(withId(R.id.editText)).check(matches(withHint("Enter Movie Name")));
    }

    @Test
    public void shouldDisplayErrorOnEmptyName() {
        //perform click action
        onView(withId(R.id.button))
                .perform(click());
    }

    @Test
    public void changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_TYPED),
                closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
    }
}
