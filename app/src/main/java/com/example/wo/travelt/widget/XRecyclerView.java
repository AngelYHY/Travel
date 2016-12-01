package com.example.wo.travelt.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.android.library.widget.recyclerview.DividerItemDecoration;
import com.example.wo.travelt.R;

/**
 * Author:  ljo_h
 * Date:    2016/9/28
 * Description:
 */
public class XRecyclerView extends RecyclerView{
    private Context context;

    public XRecyclerView(Context context) {
        this(context, null);
    }

    public XRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;

        init(attrs);
    }

    private void init(AttributeSet attrs){
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.XRecyclerView);
        if(array.getBoolean(R.styleable.XRecyclerView_itemdecoration, true)){
            this.addItemDecoration(new DividerItemDecoration(context,
                    DividerItemDecoration.VERTICAL_LIST));
        }
    }

}
