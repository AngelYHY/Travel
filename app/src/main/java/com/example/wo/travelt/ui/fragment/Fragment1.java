package com.example.wo.travelt.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wo.travelt.R;
import com.example.wo.travelt.base.BaseFragment;
import com.example.wo.travelt.widget.XRecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
public class Fragment1 extends BaseFragment {

    @Bind(R.id.tv_city)
    TextView mTvCity;
    @Bind(R.id.tv_search)
    TextView mTvSearch;
    @Bind(R.id.recycler_view)
    XRecyclerView mRecyclerView;

    public Fragment1() {
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
