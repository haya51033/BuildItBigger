package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class AsyncTaskActivity extends AsyncTask<Void, Void, String> {

    private MyApi myApiService;
    private final Callback callback;

    public interface Callback {
        void onResult(String joke);
        void onFailed();
        void onCancelled();
    }

    public AsyncTaskActivity(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        final MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });

        myApiService = builder.build();
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return "";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (TextUtils.isEmpty(result)) {
            callback.onFailed();
        } else {
            callback.onResult(result);
        }
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
        callback.onCancelled();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        callback.onCancelled();
    }
}
