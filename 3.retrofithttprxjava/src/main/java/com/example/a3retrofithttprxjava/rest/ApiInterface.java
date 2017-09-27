package com.example.a3retrofithttprxjava.rest;

import com.example.a3retrofithttprxjava.model.MoviesResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ADMIN on 9/27/2017.
 */

public interface ApiInterface {

    // We can use Flowable or Observable. Flowable is an Observable with backpressure support.
    // Backpressure is when an Observable emits values faster than an Observer is able to handle.

    @GET("movie/top_rated")
    Flowable<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Flowable<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
