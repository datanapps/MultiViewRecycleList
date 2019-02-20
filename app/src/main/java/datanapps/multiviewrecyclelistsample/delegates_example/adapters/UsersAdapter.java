package datanapps.multiviewrecyclelistsample.delegates_example.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

import datanapps.multiviewrecyclelistsample.R;
import datanapps.multiviewrecyclelistsample.models.User;

public class UsersAdapter<T> extends AdapterDelegate<List<T>> {


    public UsersAdapter() {
        // nothing to do here
    }


    @Override
    protected boolean isForViewType(@NonNull final List<T> items, final int position) {
        return items.get(position) instanceof User;
    }


    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_user, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull final List<T> items, final int position,
                                    @NonNull final RecyclerView.ViewHolder holder,
                                    @NonNull final List<Object> payloads) {

        final User user = (User) items.get(position);
        final UserViewHolder userViewHolder = (UserViewHolder) holder;
        userViewHolder.userImage.setImageResource(user.getImage());
        userViewHolder.userName.setText(user.getName());
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView userName;
        public ImageView userImage;

        public UserViewHolder(View view) {
            super(view);
            userImage = view.findViewById(R.id.img_image_name);
            userName = view.findViewById(R.id.tv_user_name);

        }
    }
}