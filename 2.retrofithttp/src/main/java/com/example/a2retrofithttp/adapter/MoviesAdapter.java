package com.example.a2retrofithttp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a2retrofithttp.Model.Movie;
import com.example.a2retrofithttp.R;

import java.util.List;

/**
 * Created by ADMIN on 9/25/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {


    private Context context;
    private LayoutInflater inflater;
    private List<Movie> movies;

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_item_movie, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        return movieViewHolder;

        //return null;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

        MovieViewHolder.movieTitle.setText(movies.get(position).getTitle());
        MovieViewHolder.movieSubtitle.setText(movies.get(position).getReleaseDate());
        MovieViewHolder.movieDescription.setText(movies.get(position).getOverview());
        MovieViewHolder.rating.setText(movies.get(position).getVoteAverage().toString());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {


        static TextView movieTitle;
        static TextView movieSubtitle;
        static TextView movieDescription;
        static TextView rating;
        LinearLayout moviesLayout;


        public MovieViewHolder(View itemView) {
            super(itemView);

            movieTitle = (TextView) itemView.findViewById(R.id.title);
            movieSubtitle = (TextView) itemView.findViewById(R.id.subtitle);
            movieDescription = (TextView) itemView.findViewById(R.id.description);
            rating = (TextView) itemView.findViewById(R.id.rating);
            moviesLayout = (LinearLayout) itemView.findViewById(R.id.movies_layout);
        }
    }
}
