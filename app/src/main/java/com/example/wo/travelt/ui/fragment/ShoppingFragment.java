package com.example.wo.travelt.ui.fragment;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.MyLocationData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.wo.travelt.R;
import com.example.wo.travelt.adapter.CityAdapter;
import com.example.wo.travelt.adapter.MyFragmentPageAdapter;
import com.example.wo.travelt.base.AppApplication;
import com.example.wo.travelt.base.BaseFragment;
import com.example.wo.travelt.ui.activity.ShoppingCartActivity;
import com.example.wo.travelt.widget.SuperRadioGroup;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
public class ShoppingFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    @Bind(R.id.shop_city_name)
    TextView mShopCityName;
    @Bind(R.id.shopping_car)
    ImageView mShoppingCar;
    @Bind(R.id.group)
    SuperRadioGroup mGroup;
    @Bind(R.id.vp)
    ViewPager mVp;
    @Bind(R.id.rv_city)
    RecyclerView mRvCity;
    @Bind(R.id.drawer_layout_city)
    DrawerLayout mDrawerLayoutCity;

    public ShoppingFragment() {
    }

    private String[] mCity = {"苏州", "深圳", "杭州", "上海", "广州", "北京", "武汉", "成都", "天津", "重庆", "南京", "合肥"};

    private ScaleAnimation scale;
    private LocationClient mLocationClient;
    private String mLocationCity;
    private boolean isFirstIn;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            return false;
        }
    });
    private Fragment[] mFragments = {new Fragment1Shop(), new Fragment2Shop(), new Fragment3Shop(), new Fragment4Shop()};


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
        //设置预加载页面的个数，这样就不会划到其他的然后就销毁了
        mVp.setOffscreenPageLimit(3);
        //vp页面切换事件
        mVp.addOnPageChangeListener(this);
        mVp.setAdapter(new MyFragmentPageAdapter(getActivity().getSupportFragmentManager(), Arrays.asList(mFragments)));
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
                    mShopCityName.setText(mLocationCity);
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
        return R.layout.fragment_main_shop;
    }

    public DrawerLayout getDrawerLayout() {
        return mDrawerLayoutCity;
    }

    @OnClick({R.id.shop_product_city_relative, R.id.shopping_car})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shop_product_city_relative:
                //点击打开侧滑
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mShopCityName, "rotationX", 0, 360).setDuration(500);
                objectAnimator.start();
                Log.i("ShoppingFragment", "ShoppingFragment: onClick");
                mDrawerLayoutCity.openDrawer(Gravity.LEFT);
                break;
            case R.id.shopping_car:
                mShoppingCar.startAnimation(scale);
                AppApplication myApplication = (AppApplication) getActivity().getApplication();
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
        int index = -1;
        //选中哪个Button
        switch (checkedId) {
            case R.id.home:
                index = 0;
                break;
            case R.id.newscenter:
                index = 1;
                break;
            case R.id.govaffairs:
                index = 2;
                break;
            case R.id.settings:
                index = 3;
                break;
        }
        //根据当前所在页面的标号数来显示页面
        mVp.setCurrentItem(index);
    }

    //页面切换发生状态改变事件
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        mGroup.scroll(position, positionOffset);
    }

    @Override
    public void onPageSelected(int position) {
        //选中一项后调用 改变radiobutton的选中状态 根据位置找到Radiobutton
        ((RadioButton) mGroup.getChildAt(position)).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onStart() {
        super.onStart();
        mRvCity.setLayoutManager(new LinearLayoutManager(mContext));
        mRvCity.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                mDrawerLayoutCity.closeDrawer(mRvCity);
                mLocationCity = mCity[i];
                mShopCityName.setText(mLocationCity);
                mHandler.sendEmptyMessage(1);
            }

        });
        mRvCity.setAdapter(new CityAdapter(R.layout.locationcity_item, Arrays.asList(mCity)));

        //百度定位启动
        if (!mLocationClient.isStarted()) {
            mLocationClient.start();
        }
    }

}
