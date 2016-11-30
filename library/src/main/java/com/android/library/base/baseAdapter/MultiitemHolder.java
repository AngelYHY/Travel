package com.android.library.base.baseAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jact on 2016/1/11.
 */
public class MultiitemHolder {
    protected Context mContext;
    protected View mConvertView;
    protected int mPosition;
    protected int mLayoutID;
    protected SparseArray<View> mViews = null;

    public MultiitemHolder(Context context, ViewGroup parent, int position, int layoutID){
        this.mContext = context;
        this.mPosition = position;
        this.mLayoutID = layoutID;
        this.mViews = new SparseArray<View>();
        this.mConvertView = LayoutInflater.from(context).inflate(layoutID, parent, false);

        mConvertView.setTag(this);
    }

    public static MultiitemHolder get(Context context, ViewGroup parent, View convertView, int position, int layoutID){
        if(convertView == null){
            return new MultiitemHolder(context, parent, position, layoutID);
        }else{
            MultiitemHolder holder = (MultiitemHolder)convertView.getTag();
            if (holder.mLayoutID != layoutID) {
                return new MultiitemHolder(context, parent, position, layoutID);
            }
           return  holder;
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

    public int getLayout(){return mLayoutID;}

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
    public MultiitemHolder setText(int viewId, String text)
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
    public MultiitemHolder setImageResource(int viewId, int drawableId)
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
    public MultiitemHolder setImageBitmap(int viewId, Bitmap bm)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

}
