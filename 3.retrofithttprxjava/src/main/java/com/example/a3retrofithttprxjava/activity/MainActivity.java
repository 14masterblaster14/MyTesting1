package com.example.a3retrofithttprxjava.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.a3retrofithttprxjava.R;
import com.example.a3retrofithttprxjava.adapter.MoviesAdapter;
import com.example.a3retrofithttprxjava.model.Movie;
import com.example.a3retrofithttprxjava.model.MoviesResponse;
import com.example.a3retrofithttprxjava.rest.ApiClient;
import com.example.a3retrofithttprxjava.rest.ApiInterface;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    //private static final String TAG = MainActivity.class.getSimpleName();
    private static final String TAG = "@MasterBlaster";
    // TODO - insert your themoviedb.org API KEY here
    //private final static String API_KEY = "Put Your API Key :)";
    private final static String API_KEY = "4128f4e96dc7b1c7177c0749abbe6926";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MoviesAdapter adapter;
    private List<Movie> movies;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //Retrofit code starts here...

        if (API_KEY.isEmpty()) {
            Toast.makeText(this, "Please obtain your API KEY first from the moviedb.org", Toast.LENGTH_LONG).show();
            return;
        }

        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Observable<MoviesResponse> moviesResponseObservable = apiInterface.getTopRatedMovies(API_KEY);
        moviesResponseObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MoviesResponse>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.i(TAG, "onSubscribe : ");
                    }
                    @Override
                    public void onNext(@NonNull MoviesResponse moviesResponse) {
                        Log.i(TAG, "onNext : " + moviesResponse.toString());
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i(TAG, "onError : ");
                    }
                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete : ");
                    }
                });
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
