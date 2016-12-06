package com.example.wo.travelt.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wo.travelt.R;
import com.example.wo.travelt.bean.SceneImgVo;

/**
 * Created by freestar on 2016/12/6.
 */

public class SceneAdapter extends BaseQuickAdapter<SceneImgVo, BaseViewHolder> {

    public SceneAdapter() {
        super(R.layout.rv_scene, null);

    }

    @Override
    protected void convert(BaseViewHolder holder, SceneImgVo item) {
//        holder.setText(R.id.product_picture)
    }
}
