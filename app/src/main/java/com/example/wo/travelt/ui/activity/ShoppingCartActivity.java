package com.example.wo.travelt.ui.activity;

import com.example.wo.travelt.R;
import com.example.wo.travelt.base.BaseActivity;
import com.example.wo.travelt.bean.ShowShoppingCart;
import com.example.wo.travelt.view.IShoppingCartView;

import java.util.List;

//// TODO: 2016/11/30 0030
//购物车的主界面
public class ShoppingCartActivity extends BaseActivity implements IShoppingCartView {

    @Override
    protected void initView() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    public void selected(List<ShowShoppingCart> list, int position) {

    }

    @Override
    public void unselected(List<ShowShoppingCart> list, int position) {

    }

    @Override
    public void reduce(List<ShowShoppingCart> list, int position) {

    }

    @Override
    public void plus(List<ShowShoppingCart> list, int position) {

    }
}





