package com.android.library.base.baseAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.library.base.baseAdapter.internal.IMultiItemTypeSupport;

import java.util.List;

/**
 * Created by jact on 2016/1/12.
 */
public abstract class BaseForMultiItemAdapter<T> extends BaseAdapter {

    private List<T> mList;
    private Context mContext;
    private IMultiItemTypeSupport MultiItemTypeSupport;

    public BaseForMultiItemAdapter(Context context, List<T> list, IMultiItemTypeSupport multiItemTypeSupport){
        this.mContext = context;
        this.mList = list;
        this.MultiItemTypeSupport = multiItemTypeSupport;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public T getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return MultiItemTypeSupport.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return MultiItemTypeSupport.getItemViewType(position, mList.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MultiitemHolder holder = MultiitemHolder.get(mContext, parent, convertView, position, MultiItemTypeSupport.getLayoutId(position, getItem(position)));
        convert(holder, getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(MultiitemHolder holder, T item);

}
