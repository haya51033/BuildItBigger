package com.udacity.gradle.builditbigger;

import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest  {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    private IdlingResource mIdlingResource;

    @Before
    public void registerIdlingResource() {
        mIdlingResource = mActivityRule.getActivity().getIdlingResource();
        // To prove that the test fails, omit this call:
        Espresso.registerIdlingResources(mIdlingResource);
    }


    @Test
    public void retrieveJoke(){
        onView((withId(R.id.tellJokeButton)))
                .check(matches(isDisplayed()))
                .check(matches(withText("TELL JOKE")))
                .perform(click());
        SystemClock.sleep(1000);
        SystemClock.sleep(1000);
        SystemClock.sleep(1000);
        SystemClock.sleep(1000);
        SystemClock.sleep(1000);
        SystemClock.sleep(1000);

        onView((withId(R.id.textViewJoke)))
                .check(matches(isDisplayed()))
                .check(matches(not(withText(""))));

    }
}
