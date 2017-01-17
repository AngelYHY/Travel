package com.example.wo.travelt.base;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.wo.travelt.R;
import com.example.wo.travelt.injector.component.ActivityComponent;
import com.example.wo.travelt.injector.module.ActivityModule;
import com.example.wo.travelt.widget.MyToast;

import java.net.UnknownHostException;

import butterknife.ButterKnife;
import freestar.freelibrary.base.BaseAppCompatActivity;
import freestar.freelibrary.base.IView;
import freestar.freelibrary.util.netstatu.NetUtils;
import freestar.freelibrary.widge.EmptyView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jact on 2016/2/12.
 */
public abstract class BaseActivity extends BaseAppCompatActivity implements IView {
    protected MaterialDialog dialog;
    protected ActivityComponent mActivityComponent;
    protected Toolbar mToolbar;
    protected EmptyView mEmptyView;
    public int page = 1;
    protected static final int PAGE_SIZE = 5;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mToolbar = ButterKnife.findById(this, R.id.common_toolbar);
        if (null != mToolbar) {
            mToolbar.setTitle("");
            setSupportActionBar(mToolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void initInjector() {
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((AppApplication) getApplication()).getComponent())
                .build();
    }

    /*@Override
    public <T> Observable bindToLifecycle(Observable<T> observable) {
        return observable.compose(this.<T>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }*/

    @Override
    public <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
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
    protected void onNetworkConnected(NetUtils.NetType type) {
        showMsg("请注意，网络连接已连接---" + type);
    }

    @Override
    protected void onNetworkDisConnected() {
        showMsg("请注意，网络连接已断开");
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
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    public void showNetError() {
        toggleNetworkError(true, null);
    }

    @Override
    public void showLoading() {
        if (mEmptyView != null) {
            mEmptyView.showLoading();
        }
    }

    @Override
    public void hide() {
        if (mEmptyView != null) {
            mEmptyView.hide();
        }
    }

    @Override
    public void showMsg(String msg) {
//        ToastUtils.ShortToast(getApplication(), msg);
        MyToast.shortToast(getApplication(), msg);
    }

    @Override
    public void showException(Throwable ex, int flag) {
        //toggleShowError(true, msg, null);
        if (flag == 1) {
            showFail(1);
        } else if (flag == 2) {
            showFail(2);
            return;
        }
        if (ex instanceof Exception) {
            //无网络
            if (ex instanceof UnknownHostException) {
                if (mEmptyView != null) {
                    mEmptyView.showError("网络异常");
                }
            } else {
                showMsg(mContext.getString(R.string.common_error_service));
                Log.e("FreeStar", "BaseActivity→→→showException:" + ex.getMessage());
            }
        }
    }

    @Override
    public void showEmpty() {
        if (mEmptyView != null) {
            mEmptyView.showEmpty();
        }
    }

    @Override
    public void showEmpty(String msg) {
        if (mEmptyView != null) {
            mEmptyView.showEmpty();
        }
    }

    @Override
    public void showDialog() {
        showDialog(getString(R.string.loading_default_text));
    }

    @Override
    public void showDialog(String content) {
        if (dialog == null) {
            dialog = new MaterialDialog.Builder(this)
                    .progress(true, 0)
                    .content(content)
                    .canceledOnTouchOutside(false)
                    .build();
            dialog.show();
        }
    }

    @Override
    public void showFail(int flag) {

    }

    @Override
    public void hideDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mIPresenter != null) {
            mIPresenter.detachView();
        }
        /*RefWatcher refWatcher = ((AppApplication)getApplication()).getRefWatcher(this);
        refWatcher.watch(this);*/
    }

    @Override
    public void pageAdd() {
        page++;
    }

}
