package com.android.library.base.baseAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.library.enums.SectionEnum;

public class PinnedViewHolder {
	protected SparseArray<View> mViews = null;
	protected int mPosition = 0;
	protected View mConvertView = null;
	protected LayoutInflater inflater;
	protected Context mContext;

	public PinnedViewHolder(Context context, ViewGroup parent, int groupLayoutID, int childLayoutID, SectionEnum section, int position){
		this.mContext = context;
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		if(section == SectionEnum.SECTION) {
			this.mConvertView = LayoutInflater.from(context).inflate(groupLayoutID, parent, false);
		}else if(section == SectionEnum.ITEM){
			this.mConvertView = LayoutInflater.from(context).inflate(childLayoutID, parent, false);
		}
		mConvertView.setTag(this);
	}
	
	public static PinnedViewHolder get(Context context, View convertView, ViewGroup parent, int groupLayoutID, int childLayoutID, SectionEnum section, int position){
		if(convertView == null){
			return new PinnedViewHolder(context, parent, groupLayoutID, childLayoutID, section, position);
		}else{
			return (PinnedViewHolder)convertView.getTag();
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
	public PinnedViewHolder setText(int viewId, String text)
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
	public PinnedViewHolder setImageResource(int viewId, int drawableId)
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
	public PinnedViewHolder setImageBitmap(int viewId, Bitmap bm)
	{
		ImageView view = getView(viewId);
		view.setImageBitmap(bm);
		return this;
	}	
}

