package com.y.md.lostseoul.model.lostData;

import com.y.md.lostseoul.model.LostProperty;

import java.util.List;

/**
 * Created by prompt32 on 2017-05-08.
 */

public interface LostDataSource {
    interface LoadLostCallback {
        void onListLoaded(List<LostProperty> lostProperties);
        void onDataNotAvailable();
    }

    void getList(String type, LoadLostCallback callback);
}
