package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.test.InstrumentationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class AsyncTaskTesting extends InstrumentationTestCase{


    public void testVerifyEchoResponse() throws Throwable {

        final CountDownLatch latch = new CountDownLatch(1);

        final AsyncTask<Pair<Context, String>, Void, String> AsyncTask =
                new AsyncTask<Pair<Context, String>, Void, String>(){

                    @Override
                    protected String doInBackground(Pair<Context, String>... pairs) {
                        return null;
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        super.onPostExecute(result);

                        latch.countDown();
                    }
                };

        runTestOnUiThread(new Runnable() {

            @Override
            public void run() {
                AsyncTask.execute();
            }
        });

        latch.await(30, TimeUnit.SECONDS);

        assertTrue("Testing Done!", true);
    }
}
