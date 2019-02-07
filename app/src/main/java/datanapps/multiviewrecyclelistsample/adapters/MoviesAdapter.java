package datanapps.multiviewrecyclelistsample.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

import datanapps.multiviewrecyclelistsample.R;
import datanapps.multiviewrecyclelistsample.models.BaseModel;
import datanapps.multiviewrecyclelistsample.models.Movie;
import datanapps.multiviewrecyclelistsample.models.User;

public class MoviesAdapter extends AdapterDelegate<List<BaseModel>> {


    public MoviesAdapter() {

    }

    @Override
    protected boolean isForViewType(@NonNull final List<BaseModel> items, final int position) {
        return items.get(position) instanceof Movie;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_movie, parent, false);

        return new MovieViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull final List<BaseModel> items, final int position,
                                    @NonNull final RecyclerView.ViewHolder holder,
                                    @NonNull final List<Object> payloads) {

        final Movie movie = (Movie) items.get(position);
        final MovieViewHolder movieViewHolder = (MovieViewHolder) holder;
        movieViewHolder.title.setText(movie.getTitle());
        movieViewHolder.genre.setText(movie.getGenre());
        movieViewHolder.year.setText(movie.getYear());
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MovieViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            genre =  view.findViewById(R.id.genre);
            year =  view.findViewById(R.id.year);
        }
    }
}