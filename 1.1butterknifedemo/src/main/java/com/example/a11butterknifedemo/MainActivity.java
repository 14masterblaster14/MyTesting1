package com.example.a11butterknifedemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    private static final ButterKnife.Action<View> ALPHA_FADE = new ButterKnife.Action<View>() {
        @Override
        public void apply(View view, int index) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
            alphaAnimation.setFillBefore(true);
            alphaAnimation.setDuration(500);
            alphaAnimation.setStartOffset(index * 100);
            view.startAnimation(alphaAnimation);
        }
    };
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.hello)
    Button hello;
    @BindView(R.id.list_of_things)
    ListView listOfThings;
    @BindView(R.id.footer)
    TextView footer;
    @BindViews({R.id.title, R.id.subtitle, R.id.hello})
    List<View> headerView;
    private MyAdapter adapter;


    @OnClick(R.id.hello)
    public void sayHello() {
        Toast.makeText(this, "Disable your adblocker sweethearts :)!", Toast.LENGTH_SHORT).show();
        ButterKnife.apply(headerView, ALPHA_FADE);
    }

    @OnLongClick(R.id.hello)
    boolean sayGetOffMe() {
        Toast.makeText(this, "Let go of me!", Toast.LENGTH_LONG).show();
        return true;
    }

    @OnItemClick(R.id.list_of_things)
    void handleOnItemClick(int position) {
        Toast.makeText(this, "You clicked: " + adapter.getItem(position), Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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

        // Contrived code to use the bound fields.
        title.setText("Butter Knife");
        subtitle.setText("Field and method binding for Android views.");
        footer.setText("Originally by Jake Wharton modified by Vivz");
        hello.setText("I am a clickbait");

        adapter = new MyAdapter(this);
        listOfThings.setAdapter(adapter);
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
