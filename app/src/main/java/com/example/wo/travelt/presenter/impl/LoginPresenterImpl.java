package com.example.wo.travelt.presenter.impl;

import android.app.Activity;
import android.content.Context;

import com.android.library.base.BasePresenter;
import com.android.library.util.StringUtils;
import com.example.wo.travelt.core.RetrofitService;
import com.example.wo.travelt.injector.ContextLife;
import com.example.wo.travelt.presenter.ILoginPresenter;
import com.example.wo.travelt.ui.activity.LoginActivity;
import com.example.wo.travelt.view.ILoginView;
import com.trello.rxlifecycle.ActivityEvent;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by freestar on 2016/11/2.
 */

public class LoginPresenterImpl extends BasePresenter<ILoginView> implements ILoginPresenter {

    private final RetrofitService service;
    private final Context context;
    private final LoginActivity activity;

    @Inject
    public LoginPresenterImpl(RetrofitService service, @ContextLife("Application") Context context, Activity activity) {
        this.service = service;
        this.context = context;
        this.activity = (LoginActivity) activity;
    }

    @Override
    public void login(final String name, final String psw) {
        //判断密码不为空
        if (StringUtils.isEmpty(name)) {
            mView.showMsg("用户名不能为空");
            return;
        } else if (StringUtils.isEmpty(psw)) {
            mView.showMsg("密码不能为空");
            return;
        }
        mView.showDialog("登陆中，请稍后~~");
        service.login(name, psw)
                .compose(mView.<String>applySchedulers())
                .compose(activity.<String>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showException(e);
                    }

                    @Override
                    public void onNext(String s) {
                        if (s.equals("yes")) {
                            mView.login();
                        } else {
                            mView.showMsg("密码错误");
                        }
                    }
                });

    }
}
