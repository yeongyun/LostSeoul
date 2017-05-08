package com.y.md.lostseoul.adapter.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.y.md.lostseoul.R;
import com.y.md.lostseoul.model.LostProperty;
import com.y.md.lostseoul.listener.OnItemClickListener;

/**
 * Created by prompt32 on 2017-05-08.
 */

public class LostListTextViewHolder extends BaseViewHolder {

    public LostListTextViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener listener) {
        super(context, viewGroup, R.layout.row_lost_property_text, listener);
    }

    @Override
    public void onBind(LostProperty lostProperty, final int position) {
        super.onBind(lostProperty, position);
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);
                }
            }

        });
    }
}
