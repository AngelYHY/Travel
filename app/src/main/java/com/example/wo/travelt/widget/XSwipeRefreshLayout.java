package com.example.wo.travelt.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import com.android.MedicalSystem.R;
import com.android.library.widget.recyclerview.DividerItemDecoration;

/**
 * Author:  ljo_h
 * Date:    2016/9/28
 * Description:
 */
public class XSwipeRefreshLayout extends SwipeRefreshLayout {
    private Context context;

    public XSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public XSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        this.setColorSchemeResources(R.color.colorPrimary);
    }

}
