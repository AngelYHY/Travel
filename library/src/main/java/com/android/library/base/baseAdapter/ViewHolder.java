package com.android.library.base.baseAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
	protected SparseArray<View> mViews = null;
	protected int mPosition = 0;
	protected View mConvertView = null;
	protected LayoutInflater inflater;
	protected Context mContext;
	
	public ViewHolder(Context context, ViewGroup parent, int layoutid, int position){
		this.mContext = context;
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		this.mConvertView = LayoutInflater.from(context).inflate(layoutid, parent, false);
		
		mConvertView.setTag(this);
	}
	
	public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutid, int position){
		if(convertView == null){
			return new ViewHolder(context, parent, layoutid, position);
		}else{
			return (ViewHolder)convertView.getTag();
		}
	}
	
	public View getConvertView(){
		return mConvertView;
	}
	
	public int getPosition(){
		return mPosition;
	}
	
	public Context getContext(){
		return mContext;
	}
	
	/**
	 * 通过ViewID获取控件
	 * @param viewid
	 * @return
	 */
	public <T extends View> T getView(int viewid){
		View view = mViews.get(viewid);
		if(view == null){
			view = mConvertView.findViewById(viewid);
			mViews.put(viewid, view);
		}
		return (T)view;
	}
	
	/**
	 * 为TextView设置字符串
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public ViewHolder setText(int viewId, String text)
	{
		TextView view = getView(viewId);
		view.setText(text);
		return this;
	}

	/**
	 * 为ImageView设置图片
	 * 
	 * @param viewId
	 * @param drawableId
	 * @return
	 */
	public ViewHolder setImageResource(int viewId, int drawableId)
	{
		ImageView view = getView(viewId);
		view.setImageResource(drawableId);

		return this;
	}

	/**
	 * 为ImageView设置图片
	 * 
	 * @param viewId
	 * @param drawableId
	 * @return
	 */
	public ViewHolder setImageBitmap(int viewId, Bitmap bm)
	{
		ImageView view = getView(viewId);
		view.setImageBitmap(bm);
		return this;
	}	
}

