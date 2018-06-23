package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.jokedisplayer.JokeDisplayerActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        final AbstractMainFragment fragment = (AbstractMainFragment) getSupportFragmentManager()
        .findFragmentById(R.id.fragment);
        fragment.setJokeButtonLoading(true);

        new AsyncTaskActivity(new AsyncTaskActivity.Callback() {
            @Override
            public void onResult(String joke) {
                final Intent intent = JokeDisplayerActivity.newIntent(MainActivity.this, joke);
                startActivity(intent);
            }

            @Override
            public void onFailed() {
                fragment.setJokeButtonLoading(false);
                Toast.makeText(MainActivity.this, "Failed Async!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled() {
                fragment.setJokeButtonLoading(false);
            }
        }).execute();
    }
}