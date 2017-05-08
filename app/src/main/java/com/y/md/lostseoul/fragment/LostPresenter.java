package com.y.md.lostseoul.fragment;

import android.support.annotation.NonNull;

import com.y.md.lostseoul.model.lostData.LostDataSource;
import com.y.md.lostseoul.model.lostData.LostRepository;
import com.y.md.lostseoul.model.LostProperty;

import java.util.List;

/**
 * Created by prompt32 on 2017-05-02.
 */

public class LostPresenter implements LostContract.Presenter {

    private final LostContract.View mView;
    private final LostRepository mLostRepository;
    private final String mType;

    LostPresenter(@NonNull String type, @NonNull LostRepository tabRepository, @NonNull LostContract.View view) {
        this.mType = type;
        this.mLostRepository = tabRepository;
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        loadLostProperty();
    }

    @Override
    public void loadLostProperty() {
        mLostRepository.getList(mType, new LostDataSource.LoadLostCallback() {
            @Override
            public void onListLoaded(List<LostProperty> lostProperties) {
                mView.showList(lostProperties);
            }

            @Override
            public void onDataNotAvailable() {
                mView.showLoadListError();
            }
        });
    }
}
