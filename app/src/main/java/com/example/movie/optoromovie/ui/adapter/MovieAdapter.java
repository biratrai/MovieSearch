package com.example.movie.optoromovie.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.movie.optoromovie.MovieBus.OnItemClickEvent;
import com.example.movie.optoromovie.R;
import com.example.movie.optoromovie.domain.model.MovieModel;
import com.example.movie.optoromovie.domain.util.Constants;
import com.example.movie.optoromovie.ui.activity.MovieDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolderData> {
    public LayoutInflater layoutInflater;
    public Context mContext;
    ArrayList<MovieModel> mMovieDataList;

    public MovieAdapter(Context context, ArrayList<MovieModel> mMovieArray) {
        layoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mMovieDataList = mMovieArray;
    }

    @Override
    public ViewHolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.single_movie_row, parent, false);
        ViewHolderData viewHolderData = new ViewHolderData(view);
        return viewHolderData;
    }

    @Override
    public void onBindViewHolder(ViewHolderData holder, final int position) {
        MovieModel movie = mMovieDataList.get(position);
        Picasso.with(mContext)
                .load(Constants.POSTER_PATH + movie.getPosterPath())
                .resize(250, 300)
                .placeholder(R.drawable.ic_headset)
                .error(R.drawable.ic_done)
                .into(holder.movieImageView);
        holder.titleTextView.setText(movie.getTitle());
        holder.dateTextView.setText("Release Date: " + movie.getReleaseDate());

//        Log.d("Movie", "rating: " + movie.getVoteCount().getClass());
        float movie_rating = ((movie.getVoteCount()) / 2);
        holder.ratingBar.setRating((movie_rating));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, MovieDetailActivity.class);
                MovieModel movie = mMovieDataList.get(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable("movie_data", movie);
                intent.putExtras(bundle);
                context.startActivity(intent);

                //  Get and Post the event
                EventBus.getDefault().postSticky(new OnItemClickEvent(bundle));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovieDataList.size();
    }

    public class ViewHolderData extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView movieImageView;
        public final TextView titleTextView;
        public final TextView dateTextView;
        public final RatingBar ratingBar;
        public final Button button;

        public ViewHolderData(View itemView) {
            super(itemView);
            mView = itemView;
            movieImageView = (ImageView) itemView.findViewById(R.id.imageView);
            titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            dateTextView = (TextView) itemView.findViewById(R.id.releaseDateTextView);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);
            button = (Button) itemView.findViewById(R.id.button);
        }
    }


}

