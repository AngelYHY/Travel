package com.android.library.base.baseAdapter.internal;

/**
 * Created by jact on 2016/1/16.
 */
public interface IMultiItemTypeSupport<T> {
    int getLayoutId(int position, T t);
    int getViewTypeCount();
    int getItemViewType(int postion, T t);
}
