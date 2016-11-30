package com.example.wo.travelt.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/7/16.
 * 用于MainActivity的适配器，多个Fragment滑动
 */
public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;
    List<String> titles;

    public MyFragmentPageAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return (fragmentList == null) ? null : fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return (fragmentList == null) ? 0 : fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


}
