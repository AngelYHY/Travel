package com.example.wo.travelt.view;

import com.example.wo.travelt.bean.ShowShoppingCart;

import java.util.List;

import freestar.freelibrary.base.IView;

/**
 * Created by Administrator on 2016/11/30 0030.
 */

public interface IShoppingCartView extends IView {
    void selected(List<ShowShoppingCart> list, int position);

    void unselected(List<ShowShoppingCart> list, int position);

    void reduce(List<ShowShoppingCart> list, int position);

    void plus(List<ShowShoppingCart> list, int position);

}
