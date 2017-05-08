package com.y.md.lostseoul.model.lostData;

import android.support.annotation.NonNull;

import com.y.md.lostseoul.model.LostProperty;

import java.util.List;

/**
 * Created by prompt32 on 2017-05-08.
 */

public class LostRepository implements LostDataSource {

    private static LostRepository mInstance = null;
    private  final LostRemoteDataSource mLostDataSource;

    private LostRepository(@NonNull LostRemoteDataSource dataSource) {
        mLostDataSource = dataSource;
    }

    public static LostRepository getInstance(LostRemoteDataSource dataSource) {
        if(mInstance == null) {
            mInstance = new LostRepository(dataSource);
        }
        return mInstance;
    }

    @Override
    public void getList(String type, LoadLostCallback callback) {
        getListFromRemoteDataSource(type, callback);
    }

    private void getListFromRemoteDataSource(@NonNull String type, @NonNull final LoadLostCallback callback) {
        mLostDataSource.getList(type, new LoadLostCallback() {
            @Override
            public void onListLoaded(List<LostProperty> lostProperties) {
                callback.onListLoaded(lostProperties);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }
}
