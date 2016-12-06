package com.example.wo.travelt.presenter.impl;

import android.support.v4.app.Fragment;

import com.android.library.base.BasePresenter;
import com.example.wo.travelt.bean.SceneImgVo;
import com.example.wo.travelt.core.RetrofitService;
import com.example.wo.travelt.presenter.IHomePagePresenter;
import com.example.wo.travelt.ui.fragment.HomePageFragment;
import com.example.wo.travelt.view.IHomePageView;
import com.trello.rxlifecycle.FragmentEvent;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by freestar on 2016/12/6.
 */

public class HomePagePresenterImpl extends BasePresenter<IHomePageView> implements IHomePagePresenter {

    private final RetrofitService mService;
    private final HomePageFragment mFragment;

    @Inject
    HomePagePresenterImpl(RetrofitService service, Fragment fragment) {
        mFragment = (HomePageFragment) fragment;
        mService = service;
    }

    @Override
    public void getScene() {
        mService.getScene()
                .compose(mView.<SceneImgVo>applySchedulers())
                .compose(mFragment.<SceneImgVo>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(new Subscriber<SceneImgVo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SceneImgVo result) {
                        mView.receive(result);
                    }
                });

    }
}
