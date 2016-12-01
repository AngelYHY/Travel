package com.example.wo.travelt.ui.fragment;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.MyLocationData;
import com.example.wo.travelt.R;
import com.example.wo.travelt.base.BaseFragment;
import com.example.wo.travelt.base.MyApplication;
import com.example.wo.travelt.ui.activity.ShoppingCartActivity;
import com.example.wo.travelt.widget.SuperRadioGroup;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
public class Fragment3Shop extends BaseFragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    @Bind(R.id.shop_city_name)
    TextView mShopcityname;
    @Bind(R.id.gouwuzhegezi)
    TextView mGouwuzhegezi;
    @Bind(R.id.shopping_car)
    ImageView mShoppingcartPicture;
    @Bind(R.id.group)
    SuperRadioGroup mGroup;
    @Bind(R.id.vp)
    ViewPager mContent;
    @Bind(R.id.rv_city)
    RecyclerView mRecyclerView;
    @Bind(R.id.drawer_layout_city)
    DrawerLayout mDrawerlayoutcity;

    private String[] citys = {"苏州", "深圳", "杭州", "上海", "广州", "北京", "武汉", "成都", "天津", "重庆", "南京", "合肥"};
    private DrawerLayout mDrawerLayout;

    private ScaleAnimation scale;
    private LocationClient mLocationClient;
    private String mLocationCity;
    private boolean isFirstIn;
    private Handler mHandler;
    private Fragment[] mFragments = {};

    public Fragment3Shop() {
    }

    @Override
    protected void initView() {
        scale = (ScaleAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.scale);

        //定位访问
        initLocation();
//        rb选中事件。从第一个选中到第二个选中，状态的改变。
        mGroup.setOnCheckedChangeListener(this);
        initVP();
    }

    private void initVP() {
        //        设置预加载页面的个数，这样就不会划到其他的然后就销毁了
        mContent.setOffscreenPageLimit(3);
        //        vp页面切换事件
        mContent.addOnPageChangeListener(this);
    }

    //    百度地图定位的一些方法
    private void initLocation() {
        mLocationClient = new LocationClient(getContext());
        mLocationClient.registerLocationListener(new BDLocationListener() {
            //定位成功后的回调
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                // 构造定位数据     打上//可以更好的展示代码
                new MyLocationData.Builder()//
                        .accuracy(bdLocation.getRadius())// 此处设置开发者获取到的方向信息，顺时针0-360
                        .latitude(bdLocation.getLatitude())//
                        .longitude(bdLocation.getLongitude())//
                        .build();
                if (isFirstIn) {
                    String city1 = bdLocation.getCity();
                    mLocationCity = city1.substring(0, 2);
                    mShopcityname.setText(mLocationCity);
                    isFirstIn = false;
                    mHandler.sendEmptyMessage(1);
                }
            }
        }); //进行注册

        LocationClientOption option = new LocationClientOption();

        option.setCoorType("bd09ll");//坐标类型
        option.setIsNeedAddress(true);//返回当前的位置
        option.setOpenGps(true);
//        option.setScanSpan(1000);//1s刷新
        mLocationClient.setLocOption(option);

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main_shop;
    }

    public DrawerLayout getDrawerlayout() {
        return mDrawerLayout;
    }


    @OnClick({R.id.shop_product_city_relative, R.id.shopping_car})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shop_product_city_relative:
                //点击打开侧滑
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mShopcityname, "rotationX", 0, 360).setDuration(500);
                objectAnimator.start();
                Log.i("Fragment3", "Fragment3: onClick");
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.shopping_car:
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

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
