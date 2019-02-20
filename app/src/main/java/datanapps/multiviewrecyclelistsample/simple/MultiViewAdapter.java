package datanapps.multiviewrecyclelistsample.simple;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import datanapps.multiviewrecyclelistsample.R;
import datanapps.multiviewrecyclelistsample.models.BaseModel;
import datanapps.multiviewrecyclelistsample.models.Header;
import datanapps.multiviewrecyclelistsample.models.Movie;
import datanapps.multiviewrecyclelistsample.models.RectHeader;
import datanapps.multiviewrecyclelistsample.models.User;

/*
 *
 * Yogendra
 * 11/02/2019
 *
 *
 * This is single adapter that contain multiple view
 *
 * All different model can handle by one adapter
 *
 * */
public class MultiViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BaseModel> feedItems;
    private LayoutInflater inflater;

    /*
     * define a constant for identify better
     * */
    final int USER = 0;
    final int RECT_HEADER = 1;
    final int MOVIE = 2;
    final int HEADER = 3;

    /*
     *
     * */
    MultiViewAdapter(Context context) {
        feedItems = new ArrayList<>();
        inflater = LayoutInflater.from(context);

    }

    /*
     * getter for feed item list
     * */
    public void setFeedItems(List<BaseModel> feedItems) {
        this.feedItems = feedItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return feedItems == null ? 0 : feedItems.size();
    }

    @Override
    public int getItemViewType(int position) {

        BaseModel baseModel = feedItems.get(position);
        if (baseModel instanceof User) {
            return USER;
        } else if (baseModel instanceof RectHeader) {
            return RECT_HEADER;
        } else if (baseModel instanceof Movie) {
            return MOVIE;
        } else if (baseModel instanceof Header) {
            return HEADER;
        }
        return 0;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case USER:
                return new UserViewHolder(inflater.inflate(R.layout.item_layout_user, parent, false));
            case RECT_HEADER:
                return new RectHeaderHolder(inflater.inflate(R.layout.item_layout_rect_header, parent, false));
            case MOVIE:
                return new MovieViewHolder(inflater.inflate(R.layout.item_layout_movie, parent, false));
            case HEADER:
                return new HeaderHolder(inflater.inflate(R.layout.item_layout_header, parent, false));
        }

        return new UserViewHolder(inflater.inflate(R.layout.item_layout_user, parent, false));

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()) {
            case USER:
                final User user = (User) feedItems.get(position);
                final UserViewHolder userViewHolder = (UserViewHolder) holder;
                userViewHolder.userImage.setImageResource(user.getImage());
                userViewHolder.userName.setText(user.getName());

                break;

            case RECT_HEADER:
                final RectHeader rectHeader = (RectHeader) feedItems.get(position);
                final RectHeaderHolder rectHeaderHolder = (RectHeaderHolder) holder;
                rectHeaderHolder.tvRectHeader.setText(rectHeader.getRectHeaderName());
                rectHeaderHolder.bgView.setBackgroundColor(rectHeader.getRectHeaderBgColorCode());

                break;


            case MOVIE:
                final Movie movie = (Movie) feedItems.get(position);
                final MovieViewHolder movieViewHolder = (MovieViewHolder) holder;
                movieViewHolder.title.setText(movie.getTitle());
                movieViewHolder.genre.setText(movie.getGenre());
                movieViewHolder.year.setText(movie.getYear());

                break;

            case HEADER:
                final Header header = (Header) feedItems.get(position);
                final HeaderHolder headerViewHolder = (HeaderHolder) holder;
                headerViewHolder.tvHeader.setText(header.getHeaderName() + "" + (position + 1));

                break;
        }
    }

    /*
     * All view holder defined here
     *
     * */
//============================================//

    public class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView userName;
        public ImageView userImage;

        public UserViewHolder(View view) {
            super(view);
            userImage = view.findViewById(R.id.img_image_name);
            userName = view.findViewById(R.id.tv_user_name);

        }
    }


    //============================================//

    public class RectHeaderHolder extends RecyclerView.ViewHolder {
        public TextView tvRectHeader;
        public View bgView;

        public RectHeaderHolder(View view) {
            super(view);
            bgView = view;
            tvRectHeader = view.findViewById(R.id.tv_rect_header);

        }
    }


    //============================================//
    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MovieViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            genre = view.findViewById(R.id.genre);
            year = view.findViewById(R.id.year);
        }
    }

    //============================================//

    public class HeaderHolder extends RecyclerView.ViewHolder {
        public TextView tvHeader;

        public HeaderHolder(View view) {
            super(view);

            tvHeader = view.findViewById(R.id.tv_header);

        }
    }
}
