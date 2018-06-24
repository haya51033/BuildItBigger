package com.udacity.gradle.builditbigger;

import android.os.SystemClock;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class AsyncTaskTesting extends InstrumentationTestCase{
    String jokeResult;
    Boolean jokeState = false;


    public AsyncTaskTesting(){}
    @Test
    public void TestJokeResult(){
        new AsyncTaskActivity(new AsyncTaskActivity.Callback() {
            String joke;
            @Override
            public void onResult(String joke) {
                this.joke = joke;
                jokeResult = joke;

                if(jokeResult!= null){
                    jokeState = true;
                }
            }
            @Override
            public void onFailed() { }
            @Override
            public void onCancelled() { }
        }).execute();

        SystemClock.sleep(1000);
        SystemClock.sleep(1000);
        SystemClock.sleep(1000);
        SystemClock.sleep(1000);

        assertNotNull("joke is null", jokeResult);
        assertFalse("joke is empty", jokeResult.isEmpty());

        //if jokeState = true --> then Joke is not empty!
        assertTrue("Testing Done! and Joke is not empty", jokeState);
    }
}
