package com.example.movie.optoromovie;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.movie.optoromovie.ui.activity.MovieActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)
public class IntentTest {
    public static final String STRING_TO_BE_TYPED = "fight";
    @Rule
    public IntentsTestRule<MovieActivity> mActivityRule = new IntentsTestRule<>(MovieActivity.class);

    @Test
    public void launchIntentTest() {
        // check that the button is there
        onView(withId(R.id.button)).check(matches(notNullValue()));
        onView(withId(R.id.button)).check(matches(withText("Search")));
        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_TYPED),
                closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        intended(toPackage("com.example.movie.optoromovie"));
        intended(hasExtra("Movie", "fight"));
    }
}
