package com.y.md.lostseoul.adapter.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.y.md.lostseoul.R;
import com.y.md.lostseoul.model.LostProperty;
import com.y.md.lostseoul.image.GlideHelper;
import com.y.md.lostseoul.listener.OnItemClickListener;

/**
 * Created by prompt32 on 2017-05-08.
 */

public class LostListImageViewHolder extends BaseViewHolder {

    private GlideHelper glideHelper;
    private ImageView ivImage;

    public LostListImageViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener listener) {
        super(context, viewGroup, R.layout.row_lost_property_image, listener);
        glideHelper = new GlideHelper(context);
        ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
    }

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

        glideHelper.setImage(lostProperty.getImgUrl(), ivImage);
    }
}
