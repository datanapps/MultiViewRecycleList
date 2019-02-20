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
import datanapps.multiviewrecyclelistsample.models.RectHeader;


public class RectHeaderAdapter<T> extends AdapterDelegate<List<T>> {


    public RectHeaderAdapter() {
        // nothing to do here
    }


    @Override
    protected boolean isForViewType(@NonNull final List<T> items, final int position) {
        return items.get(position) instanceof RectHeader;
    }


    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_rect_header, parent, false);

        return new RectHeaderHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull final List<T> items, final int position,
                                    @NonNull final RecyclerView.ViewHolder holder,
                                    @NonNull final List<Object> payloads) {

        final RectHeader header = (RectHeader) items.get(position);
        final RectHeaderHolder rectHeaderHolder = (RectHeaderHolder) holder;
        rectHeaderHolder.tvRectHeader.setText(header.getRectHeaderName());
        rectHeaderHolder.bgView.setBackgroundColor(header.getRectHeaderBgColorCode());
    }


    public class RectHeaderHolder extends RecyclerView.ViewHolder {
        public TextView tvRectHeader;
        public View bgView;
        public RectHeaderHolder(View view) {
            super(view);
            bgView = view;
            tvRectHeader = view.findViewById(R.id.tv_rect_header);

        }
    }
}