package com.example.wo.travelt.presenter.impl;

import android.app.Activity;
import android.content.Context;

import com.android.library.base.BasePresenter;
import com.example.wo.travelt.core.RetrofitService;
import com.example.wo.travelt.injector.ContextLife;
import com.example.wo.travelt.presenter.IGetBackPSWPresenter;
import com.example.wo.travelt.ui.activity.GetBackPSWActivity;
import com.example.wo.travelt.view.IGetBackPSWView;

import javax.inject.Inject;

/**
 * Created by freestar on 2016/11/4.
 */

public class GetBackPSWPresenterImpl extends BasePresenter<IGetBackPSWView> implements IGetBackPSWPresenter {

    private final RetrofitService mService;
    private final Context mContext;
    private final GetBackPSWActivity mActivity;

    @Inject
    public GetBackPSWPresenterImpl(RetrofitService service, @ContextLife("Application") Context context, Activity activity) {
        mService = service;
        mContext = context;
        mActivity = (GetBackPSWActivity) activity;
    }

    @Override
    public void confirm() {

    }
}
