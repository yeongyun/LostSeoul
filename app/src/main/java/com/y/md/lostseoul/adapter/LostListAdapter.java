package com.y.md.lostseoul.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

import com.y.md.lostseoul.adapter.contract.LostListAdapterContract;
import com.y.md.lostseoul.adapter.holder.LostListImageViewHolder;
import com.y.md.lostseoul.adapter.holder.LostListTextViewHolder;
import com.y.md.lostseoul.common.Constants;
import com.y.md.lostseoul.model.LostProperty;
import com.y.md.lostseoul.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prompt32 on 2017-05-08.
 */

public class LostListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements LostListAdapterContract.Model, LostListAdapterContract.View, Constants {

    private List<LostProperty> mItemList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public LostListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        return mItemList.get(position).getType();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_ROW_TEXT) {
            return new LostListTextViewHolder(mContext, parent, mOnItemClickListener);
        } else {
            return new LostListImageViewHolder(mContext, parent, mOnItemClickListener);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_ROW_TEXT) {
            LostListTextViewHolder viewHolder = (LostListTextViewHolder) holder;
            viewHolder.onBind(mItemList.get(position), position);
        } else {
            LostListImageViewHolder viewHolder = (LostListImageViewHolder) holder;
            viewHolder.onBind(mItemList.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public void addItems(List<LostProperty> properties) {
        if(properties != null && properties.size() > 0) {
            if (mItemList == null) {
                mItemList = new ArrayList<>();
            }

            int oldPosition = mItemList.size();
            this.mItemList.addAll(properties);
            notifyItemInserted(oldPosition);
        }
    }
}
