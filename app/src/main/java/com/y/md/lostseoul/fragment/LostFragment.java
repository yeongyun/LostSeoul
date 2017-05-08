package com.y.md.lostseoul.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.y.md.lostseoul.R;
import com.y.md.lostseoul.adapter.LostListAdapter;
import com.y.md.lostseoul.common.Util;
import com.y.md.lostseoul.model.lostData.LostRemoteDataSource;
import com.y.md.lostseoul.model.lostData.LostRepository;
import com.y.md.lostseoul.model.LostProperty;
import com.y.md.lostseoul.listener.OnItemClickListener;

import java.util.List;

/**
 * Created by prompt32 on 2017-05-02.
 */

public class LostFragment extends Fragment implements LostContract.View, OnItemClickListener {

    private final static String ARG_SECTION_TYPE = "arg_section_type";

    private LostContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;
    private LostListAdapter mAdapter;

    public static Fragment newInstance(String type) {
        LostFragment fragment = new LostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mAdapter = new LostListAdapter(getContext());
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String type = new Util().changeType(getContext(), getArguments().getString(ARG_SECTION_TYPE));
        mPresenter = new LostPresenter(type, LostRepository.getInstance(LostRemoteDataSource.getInstance()), this);
    }

    @Override
    public void setPresenter(LostContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showList(final List<LostProperty> lostPropertyList) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.addItems(lostPropertyList);
            }
        });
    }

    @Override
    public void showLoadListError() {
        //TODO: show error
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onItemClick(int position) {
        //TODO: item click
    }
}
