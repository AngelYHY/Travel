package com.example.wo.travelt.injector.component;

import android.app.Activity;
import android.content.Context;

import com.example.wo.travelt.injector.ContextLife;
import com.example.wo.travelt.injector.PerFragment;
import com.example.wo.travelt.injector.module.FragmentModule;
import com.example.wo.travelt.ui.fragment.Fragment1;
import com.example.wo.travelt.ui.fragment.Fragment2;
import com.example.wo.travelt.ui.fragment.Fragment3;
import com.example.wo.travelt.ui.fragment.Fragment4;

import dagger.Component;

/**
 * Created by freestar on 2016/11/3.
 */
@PerFragment
@Component(modules = FragmentModule.class, dependencies = ApplicationComponent.class)
public interface FragmentComponent {
    @ContextLife("Application")
    Context getContext();

    @ContextLife("Activity")
    Context getActivityContext();

    Activity getActivity();

    void inject(Fragment1 fragment1);

    void inject(Fragment2 fragment2);

    void inject(Fragment3 fragment3);

    void inject(Fragment4 fragment4);

}
