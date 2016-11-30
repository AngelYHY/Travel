package com.example.wo.travelt.ui.fragment;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wo.travelt.R;
import com.example.wo.travelt.base.BaseFragment;
import com.example.wo.travelt.base.MyApplication;
import com.example.wo.travelt.ui.activity.ShoppingCartActivity;
import com.example.wo.travelt.widget.SuperRadioGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
public class Fragment3 extends BaseFragment {

    @Bind(R.id.shopcityname)
    TextView mShopcityname;
    @Bind(R.id.gouwuzhegezi)
    TextView mGouwuzhegezi;
    @Bind(R.id.shoppingcart_picture)
    ImageView mShoppingcartPicture;
    @Bind(R.id.group)
    SuperRadioGroup mGroup;
    @Bind(R.id.content)
    ViewPager mContent;
    @Bind(R.id.lv_drawlayout_city)
    ListView mLvDrawlayoutCity;
    @Bind(R.id.drawerlayoutcity)
    DrawerLayout mDrawerlayoutcity;
    private DrawerLayout mDrawerLayout;

    private ScaleAnimation scale;
    public Fragment3() {
    }

    @Override
    protected void initView() {
        scale = (ScaleAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.scale);

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main_shop;
    }

    public DrawerLayout getDrawerlayout() {
        return mDrawerLayout;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.shop_product_city_relative, R.id.shoppingcart_picture})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shop_product_city_relative:
                //点击打开侧滑
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mShopcityname, "rotationX", 0, 360).setDuration(500);
                objectAnimator.start();
                Log.i("Fragment3", "Fragment3: onClick");
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.shoppingcart_picture:
                mShoppingcartPicture.startAnimation(scale);
                MyApplication myApplication = (MyApplication) getActivity().getApplication();
                String accountName = myApplication.getAccountName();

                if (accountName == null || accountName.equals("")) {
                    Toast.makeText(getActivity(), "没登录，去登录", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getActivity(), ShoppingCartActivity.class);
                startActivity(intent);
                break;
        }
    }
}
