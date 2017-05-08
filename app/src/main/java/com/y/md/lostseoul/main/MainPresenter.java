package com.y.md.lostseoul.main;

import android.content.Context;
import android.support.annotation.NonNull;

import com.y.md.lostseoul.model.tabData.TabRepository;

/**
 * Created by prompt32 on 2017-05-02.
 */

public class MainPresenter implements MainContract.Presenter {

    private final Context mContext;
    private final MainContract.View mView;
    private final TabRepository mTabRepository;

    MainPresenter(@NonNull Context context, @NonNull TabRepository tabRepository, @NonNull MainContract.View view) {
        this.mContext = context;
        this.mTabRepository = tabRepository;
        this.mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        getFilters();
    }

    @Override
    public void getFilters() {
        mView.setFilters(mTabRepository.getFilters(mContext));
    }
}
