package datanapps.multiviewrecyclelistsample.delegates_example.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

import datanapps.multiviewrecyclelistsample.R;
import datanapps.multiviewrecyclelistsample.models.Header;

public class HeaderAdapter<T> extends AdapterDelegate<List<T>> {


    public HeaderAdapter() {
        // nothing to do here
    }


    @Override
    protected boolean isForViewType(@NonNull final List<T> items, final int position) {
        return items.get(position) instanceof Header;
    }


    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_header, parent, false);

        return new HeaderHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull final List<T> items, final int position,
                                    @NonNull final RecyclerView.ViewHolder holder,
                                    @NonNull final List<Object> payloads) {

        final Header header = (Header) items.get(position);
        final HeaderHolder userViewHolder = (HeaderHolder) holder;

        userViewHolder.tvHeader.setText(header.getHeaderName()+""+(position+1));
    }


    public class HeaderHolder extends RecyclerView.ViewHolder {
        public TextView tvHeader;

        public HeaderHolder(View view) {
            super(view);

            tvHeader = view.findViewById(R.id.tv_header);

        }
    }
}