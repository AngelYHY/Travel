package com.android.library.base.baseAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class BaseForAdapter<T> extends BaseAdapter {

	private Context mContext;
	private List<T> mDatas;
	private int mLayoutid = 0;
	
	public BaseForAdapter(Context context, List<T> datas, int layoutid){
		this.mContext = context;
		this.mDatas = datas;
		this.mLayoutid = layoutid;
	}
	
	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//ViewHolder holder = new ViewHolder(mContext, parent, mLayoutid, position);
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, mLayoutid, position);
		convert(holder, getItem(position), position);
		return holder.getConvertView();
	}
	
	public abstract void convert(ViewHolder holder, T item, int position);

}
