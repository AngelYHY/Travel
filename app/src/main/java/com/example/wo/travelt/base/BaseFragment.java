package com.example.wo.travelt.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.library.base.IPresenter;
import com.android.library.base.IView;
import com.android.library.base.baseAdapter.BaseAppCompatFragment;
import com.android.library.util.netstatu.NetUtils;
import com.example.wo.travelt.R;
import com.example.wo.travelt.injector.component.DaggerFragmentComponent;
import com.example.wo.travelt.injector.component.FragmentComponent;
import com.example.wo.travelt.injector.module.FragmentModule;
import com.example.wo.travelt.widget.EmptyView;
import com.example.wo.travelt.widget.MyToast;

import java.net.UnknownHostException;

import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jact on 2016/2/16.
 */
public abstract class BaseFragment extends BaseAppCompatFragment implements IView {
    protected MaterialDialog dialog;
    protected FragmentComponent mFragmentComponent;
    protected Toolbar mToolbar;
    protected EmptyView mEmptyView;
    protected int page = 1;
    protected final static int PAGE_SIZE = 5;

    protected IPresenter mIPresenter;

    @Override
    protected void initInjector() {
        mFragmentComponent = DaggerFragmentComponent.builder()
                .fragmentModule(new FragmentModule(this))
                .applicationComponent(((MyApplication) getActivity().getApplication()).getApplicationComponent())
                .build();

        mToolbar = ButterKnife.findById(getActivity(), R.id.common_toolbar);
        if (null != mToolbar) {
            mToolbar.setTitle("");
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    protected int getScreenHeight() {
        return getActivity().findViewById(android.R.id.content).getHeight();
    }

    /*@Override
    public <T> Observable bindToLifecycle(Observable<T> observable) {
        return observable.compose(this.<T>bindUntilEvent(FragmentEvent.DESTROY))
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

    /**
     * startActivity
     *
     * @param clazz
     */
    protected void readyGo(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz
     */
    protected void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
        getActivity().finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        getActivity().finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz
     * @param requestCode
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    public void showException(Throwable ex) {
        //toggleShowError(true, msg, null);
        if (ex instanceof Exception) {
            if (ex instanceof UnknownHostException) {
                if (mEmptyView != null) {
                    mEmptyView.showError("");
                }
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
    public void showNetError() {

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
//        ToastUtils.LongToast(getActivity().getApplicationContext(), msg);
        MyToast.shortToast(getActivity().getApplicationContext(), msg);
    }

    @Override
    public void showDialog() {
        showDialog(getString(R.string.loading_default_text));
    }

    @Override
    public void showDialog(String content) {
        if (dialog == null) {
            dialog = new MaterialDialog.Builder(getActivity())
                    .progress(true, 0)
                    .content(content)
                    .canceledOnTouchOutside(false)
                    .build();
            dialog.show();
        }
    }

    @Override
    public void hideDialog() {
        if (dialog == null) {
            dialog.dismiss();
        }
    }

    @Override
    public void showLoadMoreFail() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mIPresenter != null) {
            mIPresenter.detachView();
        }
        /*RefWatcher refWatcher = ((AppApplication)getActivity().getApplication()).getRefWatcher(getActivity());
        refWatcher.watch(this);*/
    }

}
