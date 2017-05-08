package com.y.md.lostseoul.fragment;

import com.y.md.lostseoul.BasePresenter;
import com.y.md.lostseoul.BaseView;
import com.y.md.lostseoul.model.LostProperty;

import java.util.List;

/**
 * Created by prompt32 on 2017-05-02.
 */

public interface LostContract {

    interface View extends BaseView<Presenter> {
        void showList(List<LostProperty> lostPropertyList);
        void showLoadListError();
    }

    interface Presenter extends BasePresenter {
        void loadLostProperty();
    }

}
