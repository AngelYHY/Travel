package com.example.wo.travelt.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.Menu;

import com.example.wo.travelt.R;
import com.example.wo.travelt.adapter.MyFragmentPageAdapter;
import com.example.wo.travelt.base.BaseActivity;
import com.example.wo.travelt.ui.fragment.Fragment4;
import com.example.wo.travelt.ui.fragment.HomePageFragment;
import com.example.wo.travelt.ui.fragment.PublishFragment;
import com.example.wo.travelt.ui.fragment.ShoppingFragment;
import com.example.wo.travelt.view.IMainView;
import com.example.wo.travelt.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * Created by freestar on 2016/11/4.
 */
public class MainActivity extends BaseActivity implements IMainView {

    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.custom_viewPage)
    CustomViewPager mViewPager;
    private List<Fragment> mFragments;
    private ShoppingFragment mShoppingFragment;
    private String mLocalCity;

    @Override
    protected void initView() {
        initVP();
    }

    public String getLocalCity() {
        return mLocalCity;
    }

    private void initVP() {
        mShoppingFragment = new ShoppingFragment();
        mFragments = new ArrayList<>();
        String[] titles = {"首页", "发布", "购物", "我的"};
        mViewPager.setOffscreenPageLimit(3);
        mFragments.add(new HomePageFragment());
        mFragments.add(new PublishFragment());
        mFragments.add(mShoppingFragment);
        mFragments.add(new Fragment4());

        MyFragmentPageAdapter mAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(), mFragments, Arrays.asList(titles));
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
    public void updateCity(String city) {
        mLocalCity = city;
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
        if (mShoppingFragment != null && mShoppingFragment.getDrawerLayout() != null) {
            if (mShoppingFragment.getDrawerLayout().isDrawerOpen(GravityCompat.START)) {
                mShoppingFragment.getDrawerLayout().closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }
}
