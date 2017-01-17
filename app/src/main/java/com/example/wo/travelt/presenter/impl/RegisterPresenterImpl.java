package com.example.wo.travelt.presenter.impl;

import android.app.Activity;

import com.example.wo.travelt.core.RetrofitService;
import com.example.wo.travelt.presenter.IRegisterPresenter;
import com.example.wo.travelt.ui.activity.RegisterActivity;
import com.example.wo.travelt.view.IRegisterView;
import com.trello.rxlifecycle.ActivityEvent;

import javax.inject.Inject;

import freestar.freelibrary.base.BasePresenter;
import freestar.freelibrary.util.StringUtils;
import rx.Subscriber;

/**
 * Created by freestar on 2016/11/4.
 */

public class RegisterPresenterImpl extends BasePresenter<IRegisterView> implements IRegisterPresenter {

    private final RetrofitService mService;
    private final RegisterActivity mActivity;

    @Inject
    RegisterPresenterImpl(RetrofitService service, Activity activity) {
        mService = service;
        mActivity = (RegisterActivity) activity;
    }


    @Override
    public void register(String name, String psw, String confirmPsw, String phone) {
        if (StringUtils.isEmpty(name)) {
            mView.showMsg("用户名不能为空");
            return;
        } else if (StringUtils.isEmpty(psw)) {
            mView.showMsg("密码不能为空");
            return;
        } else if (StringUtils.isEmpty(confirmPsw)) {
            mView.showMsg("确认密码不能为空");
            return;
        } else if (!psw.equals(confirmPsw)) {
            mView.showMsg("密码和确认密码不能为空");
            return;
        }
        mView.showDialog();
        mService.register(name, psw, phone)
                .compose(mView.<String>applySchedulers())
                .compose(mActivity.<String>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hide();
                        mView.showException(e,0);
                    }

                    @Override
                    public void onNext(String s) {
                        mView.hide();
                        switch (s) {
                            case "no":
                                mView.showMsg("用户名已存在...");
                                break;
                            case "no1":
                                mView.showMsg("手机号已被注册...");
                                mView.go(false);
                                break;
                            case "yes":
                                mView.showMsg("恭喜您注册成功");
                                mView.go(true);
                                break;
                        }
                    }
                });
    }
}
