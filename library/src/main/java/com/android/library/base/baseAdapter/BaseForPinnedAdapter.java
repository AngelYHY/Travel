package com.android.library.base.baseAdapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.android.library.enums.SectionEnum;
import com.android.library.widget.pinnedsectionlistview.PinnedSectionListView;

import java.util.List;

/**
 * Created by jact on 2016/1/12.
 */
public abstract class BaseForPinnedAdapter<T> extends ArrayAdapter implements PinnedSectionListView.PinnedSectionListAdapter{

    public BaseForPinnedAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return viewType == SectionEnum.SECTION.ordinal();
    }

}
