package com.android.library.base.baseAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.android.library.base.baseAdapter.internal.IExpandItemSupport;

import java.util.List;

/**
 * Created by jact on 2016/1/11.
 */
public  abstract class BaseForExpandAdapter<T, TChiID> extends BaseExpandableListAdapter {
    private Context mContext;
    private List<T> mGroupList;
    private List<List<TChiID>> mChildList;
    private IExpandItemSupport mExpandItemSupport;

    public BaseForExpandAdapter(Context context, List<T> groupList, List<List<TChiID>> childList, IExpandItemSupport expandItemSupport){
        this.mContext = context;
        this.mGroupList = groupList;
        this.mChildList = childList;
        this.mExpandItemSupport = expandItemSupport;
    }

    @Override
    public int getGroupCount() {
        return mGroupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mChildList.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChildList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int position, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        //GroupViewHolder holder = GroupViewHolder.get(mContext, parent, convertView, groupPosition, isExpanded, mGroupLayoutID);
        //groupConvert(holder, mGroupList.get(groupPosition));

        MultiitemHolder holder = MultiitemHolder.get(mContext, parent, convertView, position, mExpandItemSupport.getLayoutId(position, getGroup(position)));
        groupConvert(holder, mGroupList.get(position));
        return  holder.getConvertView();
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        //ChildViewHolder holder = ChildViewHolder.get(mContext, parent, convertView, groupPosition, childPosition, isLastChild, mChildLayoutID);
        //childConvert(holder, mChildList.get(groupPosition).get(childPosition));

        MultiitemHolder holder = MultiitemHolder.get(mContext, parent, convertView, groupPosition, mExpandItemSupport.getLayoutId(groupPosition, getChild(groupPosition, childPosition)));
        childConvert(holder, mChildList.get(groupPosition).get(childPosition));
        return  holder.getConvertView();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public abstract void groupConvert(MultiitemHolder holder, T item);
    public abstract void childConvert(MultiitemHolder holder, TChiID item);
}
