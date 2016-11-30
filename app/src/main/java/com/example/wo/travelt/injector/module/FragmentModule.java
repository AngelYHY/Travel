package com.example.wo.travelt.injector.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.wo.travelt.injector.ContextLife;
import com.example.wo.travelt.injector.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by freestar on 2016/11/3.
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PerFragment
    @ContextLife("Activity")
    public Context provideContext() {
        return fragment.getActivity();
    }

    @PerFragment
    @Provides
    public Activity provideActivity() {
        return fragment.getActivity();
    }

    @Provides
    @PerFragment
    public Fragment provideFragment() {
        return fragment;
    }
}
