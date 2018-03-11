package com.example.a8databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.a8databinding.databinding.ActivityMainBinding;


/*

<-- In build.gradle file, we need to add following gradle property which enabled data binding -->

1.-->>
            android {
              ...
              dataBinding {
                    enabled = true
                }
              ...
            }

            OR

            android {
                compileSdkVersion 24
                buildToolsVersion "24.0.0"
                dataBinding.enabled = true
                ...
            }
2 .-->>

        All layout files that intend to use data binding techniques must have a layout root tag.

*/
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //---- Before Data Binding ------//
        /*

        setContentView(R.layout.activity_main);
        Button button_update = findViewById(R.id.updateButton);
        Button button_next_activity = (Button)findViewById(R.id.nextActivityButton);
        TextView textviewHeader = findViewById(R.id.textView1);
        textview = findViewById(R.id.textView2);
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textview.setText("Welcome !!");
            }
        });
         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        //---- After Data Binding ------//
        ///*
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(activityMainBinding.includedToolbar.toolbar);
        activityMainBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        activityMainBinding.includedContentMain.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityMainBinding.includedContentMain.textView2.setText("Welcome !!!");
            }
        });
        activityMainBinding.includedContentMain.UserActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserActivity.class));
            }
        });

        // */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
