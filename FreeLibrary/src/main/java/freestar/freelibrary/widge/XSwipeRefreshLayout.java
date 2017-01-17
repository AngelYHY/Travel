package freestar.freelibrary.widge;


import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import freestar.freelibrary.R;


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
