package com.y.md.lostseoul.adapter.contract;

import com.y.md.lostseoul.model.LostProperty;
import com.y.md.lostseoul.listener.OnItemClickListener;

import java.util.List;

/**
 * Created by prompt32 on 2017-05-08.
 */

public interface LostListAdapterContract {
    interface View {
        void notifyAdapter();
        void setOnItemClickListener(OnItemClickListener listener);
    }

    interface Model {
        void addItems(List<LostProperty> properties);
    }
}
