package com.example.wo.travelt.presenter.impl;

import android.app.Activity;
import android.content.Context;

import com.android.library.base.BasePresenter;
import com.android.library.util.PreferencesUtils;
import com.android.library.util.StringUtils;
import com.example.wo.travelt.constant.Preferences;
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


    private final RetrofitService mService;
    private final Context mContext;
    private final LoginActivity mActivity;

    @Inject
    public LoginPresenterImpl(RetrofitService service, @ContextLife("Application") Context context, Activity activity) {
        mService = service;
        mContext = context;
        mActivity = (LoginActivity) activity;
    }

    @Override
    public void login(final String name, final String psw, final boolean isRemember, boolean isAutoLogin) {
        //判断密码不为空
        if (StringUtils.isEmpty(name)) {
            mView.showMsg("用户名不能为空");
            return;
        } else if (StringUtils.isEmpty(psw)) {
            mView.showMsg("密码不能为空");
            return;
        }
        mView.showDialog("登陆中，请稍后~~");
        mService.login(name, psw)
                .compose(mView.<String>applySchedulers())
                .compose(mActivity.<String>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showException(e);
                        mView.hideDialog();
                    }

                    @Override
                    public void onNext(String s) {
                        if (s.equals("yes")) {
                            mView.login();
                            if (isRemember) {
                                PreferencesUtils.putString(mContext, Preferences.NAME, name);
                                PreferencesUtils.putString(mContext, Preferences.PSW, psw);
                                PreferencesUtils.putBoolean(mContext, Preferences.LOGIN_CHK_STATE, true);
                            } else {
                                PreferencesUtils.putString(mContext, Preferences.PSW, "");
                                PreferencesUtils.putBoolean(mContext, Preferences.LOGIN_CHK_STATE, false);
                                PreferencesUtils.putString(mContext, Preferences.NAME, name);
                            }
                        } else if (s.equals("帐号不正确")) {
                            mView.showMsg(s);
                        } else {
                            mView.showMsg("密码错误");
                        }
                    }
                });
    }

}
