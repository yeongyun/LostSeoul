package com.y.md.lostseoul.main;

import com.y.md.lostseoul.BasePresenter;
import com.y.md.lostseoul.BaseView;

/**
 * Created by prompt32 on 2017-05-02.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {
        void setFilters(String[] filters);
    }

    interface Presenter extends BasePresenter {
        void getFilters();
    }

}
