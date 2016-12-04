package com.example.wo.travelt.base;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.library.base.BaseAppCompatActivity;
import com.android.library.base.IView;
import com.android.library.util.netstatu.NetUtils;
import com.example.wo.travelt.R;
import com.example.wo.travelt.injector.component.ActivityComponent;
import com.example.wo.travelt.injector.component.DaggerActivityComponent;
import com.example.wo.travelt.injector.module.ActivityModule;
import com.example.wo.travelt.widget.EmptyView;
import com.example.wo.travelt.widget.MyToast;

import java.net.UnknownHostException;

import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by freestar on 2016/11/2.
 */

public abstract class BaseActivity extends BaseAppCompatActivity implements IView {

    protected Toolbar toolbar;
    protected ActivityComponent mActivityComponent;
    protected MaterialDialog dialog;
    protected EmptyView emptyView;
    protected int page = 1;
    protected static final int PAGE_SIZE = 5;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        toolbar = ButterKnife.findById(this, R.id.common_toolbar);
        if (toolbar != null) {
            toolbar.setTitle("");
            setSupportActionBar(toolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return true;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.FADE;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected void initInjector() {
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MyApplication) getApplication()).getApplicationComponent())
                .build();
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    public void showLoading() {
        if (emptyView != null) {
            emptyView.showLoading();
        }
    }

    @Override
    public void hide() {
        if (emptyView != null) {
            emptyView.hide();
        }
    }

    @Override
    public void showException(Throwable ex) {
        try {
            if (ex instanceof Exception) {
                if (ex instanceof UnknownHostException) {
                    if (emptyView != null) {
                        emptyView.showError("无法识别主机");
                    }
                } else {
                    showMsg(mContext.getString(R.string.common_error_service));
                }

            }
        } catch (Exception e) {

        }
    }

    @Override
    public void showNetError() {
        toggleNetworkError(true, null);
    }

    @Override
    public void showMsg(String msg) {
        MyToast.shortToast(getApplication(), msg);
    }

    @Override
    public void showEmpty(String msg) {
        if (emptyView != null) {
            emptyView.showEmpty();
        }
    }

    @Override
    public void showEmpty() {
        if (emptyView != null) {
            emptyView.showEmpty();
        }
    }

    @Override
    public void showDialog(String content) {
        if (dialog == null) {
            dialog = new MaterialDialog.Builder(mContext)
                    .progress(true, 0)
                    .content(content)
                    .canceledOnTouchOutside(false)
                    .build();
            dialog.show();
        }
    }

    @Override
    public void showDialog() {
        showDialog(getString(R.string.loading_default_text));
    }

    @Override
    public void hideDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mIPresenter != null) {
            mIPresenter.detachView();
        }
    }
}
