package com.y.md.lostseoul.model.tabData;

import android.content.Context;

import com.y.md.lostseoul.R;

/**
 * Created by prompt32 on 2017-05-02.
 */

public class TabRepository implements TabDataSource {

    private static TabRepository mInstance = null;

    public static TabRepository getInstance() {
        if(mInstance == null) {
            mInstance = new TabRepository();
        }
        return mInstance;
    }

    @Override
    public String[] getFilters(Context context) {
        return context.getResources().getStringArray(R.array.filter);
    }
}
