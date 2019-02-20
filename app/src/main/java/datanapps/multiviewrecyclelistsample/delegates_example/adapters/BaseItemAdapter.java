package datanapps.multiviewrecyclelistsample.delegates_example.adapters;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import java.util.ArrayList;
import java.util.List;

import datanapps.multiviewrecyclelistsample.models.BaseModel;

public class BaseItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private AdapterDelegatesManager<List<BaseModel>> delegatesManager;

    private List<BaseModel> feedItems;


    public BaseItemAdapter() {
        feedItems = new ArrayList<>(10);
        delegatesManager = new AdapterDelegatesManager<>();
    }

    public void setFeedItems(final List<BaseModel> feedItems) {
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffCallback(this.feedItems, feedItems));
        this.feedItems = feedItems;
        diffResult.dispatchUpdatesTo(this);
    }

    public void clearFeedItems() {
        feedItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getItemViewType(final int position) {
        return delegatesManager.getItemViewType(feedItems, position);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        delegatesManager.onBindViewHolder(feedItems, position, holder);
    }

    @Override
    public void onViewRecycled(final RecyclerView.ViewHolder holder) {
        delegatesManager.onViewRecycled(holder);
    }

    @Override
    public void onViewAttachedToWindow(final RecyclerView.ViewHolder holder) {
        delegatesManager.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(final RecyclerView.ViewHolder holder) {
        delegatesManager.onViewDetachedFromWindow(holder);
    }

    @Override
    public int getItemCount() {
        return feedItems == null ? 0 : feedItems.size();
    }

    public BaseModel getFeedByPosition(final int position) {
        return feedItems.get(position);
    }

    public void addDelegate(final AdapterDelegate<List<BaseModel>> adapterDelegate) {
        delegatesManager.addDelegate(adapterDelegate);
    }

    public void addFeedItems(final List<BaseModel> items) {
        final int positionStart = feedItems.size() - 1;
        final int itemCount = items.size();
        feedItems.addAll(items);
        notifyItemRangeInserted(positionStart, itemCount);
    }

    public List<BaseModel> getFeedItems() {
        return feedItems;
    }

    private static class DiffCallback extends DiffUtil.Callback {

        private final List<BaseModel> oldList;
        private final List<BaseModel> newList;

        private DiffCallback(final List<BaseModel> oldList, final List<BaseModel> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() {
            return oldList.size();
        }

        @Override
        public int getNewListSize() {
            return newList.size();
        }

        @Override
        public boolean areItemsTheSame(final int oldItemPosition, final int newItemPosition) {
            return oldList.get(oldItemPosition) == newList.get(newItemPosition);
        }

        @Override
        public boolean areContentsTheSame(final int oldItemPosition, final int newItemPosition) {
            return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
        }
    }
}