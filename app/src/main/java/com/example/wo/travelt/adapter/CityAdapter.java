package com.example.wo.travelt.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by freestar on 2016/12/1.
 */

public class CityAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public CityAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String s) {

    }
}
