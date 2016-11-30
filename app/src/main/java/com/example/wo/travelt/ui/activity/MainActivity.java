package com.example.wo.travelt.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.Menu;

import com.example.wo.travelt.R;
import com.example.wo.travelt.adapter.MyFragmentPageAdapter;
import com.example.wo.travelt.base.BaseActivity;
import com.example.wo.travelt.ui.fragment.Fragment1;
import com.example.wo.travelt.ui.fragment.Fragment2;
import com.example.wo.travelt.ui.fragment.Fragment3;
import com.example.wo.travelt.view.IMainView;
import com.example.wo.travelt.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by freestar on 2016/11/4.
 */
public class MainActivity extends BaseActivity implements IMainView {

    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.custom_viewPage)
    CustomViewPager mViewPager;
    private List<Fragment> mFragments;
    private ArrayList<String> mTitles;
    private Fragment3 mFragment3;
    private String mLocationcity;

    @Override
    protected void initView() {
        initVP();
    }

    public String getLocationcity() {
        return mLocationcity;
    }

    private void initVP() {
        mFragment3 = new Fragment3();
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();
        mViewPager.setOffscreenPageLimit(3);
        mFragments.add(new Fragment1());
        mFragments.add(new Fragment2());
        mFragments.add(mFragment3);
        mTitles.add("首页");
        mTitles.add("发布");
        mTitles.add("购物");
        mTitles.add("我的");
        MyFragmentPageAdapter mAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mViewPager.setAdapter(mAdapter);
        //将TabLayout与ViewPager绑定起来
        mTabLayout.setupWithViewPager(mViewPager);

        //设置图片
        TabLayout.Tab tab;
        Drawable drawable = null;
        for (int i = 0, len = mTabLayout.getTabCount(); i < len; i++) {
            tab = mTabLayout.getTabAt(i);
            switch (i) {
                case 0:
                    drawable = getResources().getDrawable(R.drawable.selector_home);
                    break;
                case 1:
                    drawable = getResources().getDrawable(R.drawable.selector_release);
                    break;
                case 2:
                    drawable = getResources().getDrawable(R.drawable.selector_shopping);
                    break;
                case 3:
                    drawable = getResources().getDrawable(R.drawable.selector_mine);
                    break;
            }
            tab.setIcon(drawable);
        }

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void updateCity(String city) {
        mLocationcity = city;
//        Log.i("MainActivity", "MainActivity: onCreate" + Locationcity);
        Intent intent = new Intent();
        intent.setAction("action.refreshcity");
        sendBroadcast(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ///getMenuInflater().inflate(R.menu.shouye_menu,menu);
        getSupportActionBar().setTitle("苏州");
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mFragment3 != null && mFragment3.getDrawerlayout() != null) {
            if (mFragment3.getDrawerlayout().isDrawerOpen(GravityCompat.START)) {
                mFragment3.getDrawerlayout().closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }
}
