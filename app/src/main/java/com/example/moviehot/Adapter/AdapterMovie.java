package com.example.moviehot.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviehot.Model.Page;
import com.example.moviehot.Model.Result;
import com.example.moviehot.R;
import com.squareup.picasso.Picasso;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.MyViewHolder> {
    private Context context;
    private Page movies;
    private final String URL_IMAGE = "https://image.tmdb.org/t/p/w500/";


    public AdapterMovie(Context context) {
        this.context = context;
    }

    public void setMovies(Page movies) {
        this.movies = movies;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_movie, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Result movie = movies.getResults().get(position);

        Picasso.get().load(URL_IMAGE.concat(movie.getPosterPath()))
                .into(holder.imgMovie);
        holder.tvNameMovie.setText(movie.getTitle());
        holder.tvRatingMovie.setText("Rating:"+movie.getVoteAverage());

    }

    @Override
    public int getItemCount() {
        if (movies != null)
            return movies.getResults().size();
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMovie;
        private TextView tvNameMovie, tvRatingMovie;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMovie = itemView.findViewById(R.id.img_movie);
            tvNameMovie = itemView.findViewById(R.id.tv_name_movie);
            tvRatingMovie = itemView.findViewById(R.id.tv_rating);
        }
    }
}
