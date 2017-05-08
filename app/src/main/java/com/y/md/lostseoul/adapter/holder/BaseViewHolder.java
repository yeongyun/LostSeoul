package com.y.md.lostseoul.adapter.holder;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.y.md.lostseoul.R;
import com.y.md.lostseoul.model.LostProperty;
import com.y.md.lostseoul.listener.OnItemClickListener;

/**
 * Created by prompt32 on 2017-05-08.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    public Context mContext;
    public OnItemClickListener mOnItemClickListener;

    public TextView tvName, tvID, tvPos, tvTake, tvThing, tvStatus;

    public BaseViewHolder(Context context, ViewGroup viewGroup, int layoutRes, OnItemClickListener listener) {
        super(LayoutInflater.from(context).inflate(layoutRes, viewGroup, false));
        this.mContext = context;
        this.mOnItemClickListener = listener;

        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvID = (TextView) itemView.findViewById(R.id.tvID);
        tvPos = (TextView) itemView.findViewById(R.id.tvPos);
        tvTake = (TextView) itemView.findViewById(R.id.tvTake);
        tvThing = (TextView) itemView.findViewById(R.id.tvThing);
        tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);
    }

    public void onBind(LostProperty lostProperty, final int position) {
        tvName.setText(String.format(mContext.getString(R.string.lost_name), lostProperty.getCategory(), lostProperty.getName()));
        tvID.setText("" + lostProperty.getId());
        tvPos.setText(String.format(mContext.getString(R.string.lost_position), lostProperty.getGetPosition() + " " + lostProperty.getGetPlace(), lostProperty.getDate()));
        tvTake.setText(String.format(mContext.getString(R.string.lost_take), lostProperty.getTakePlace(), lostProperty.getContact()));
        if(lostProperty.getGetThings() != null && lostProperty.getGetThings().length() > 0) {
            tvThing.setVisibility(View.VISIBLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                tvThing.setText(Html.fromHtml(lostProperty.getGetThings(), Html.FROM_HTML_MODE_LEGACY));
            } else {
                tvThing.setText(Html.fromHtml(lostProperty.getGetThings()));
            }
        } else {
            tvThing.setVisibility(View.GONE);
        }
        tvStatus.setText(String.format(mContext.getString(R.string.lost_status), lostProperty.getStatus()));
    }
}
