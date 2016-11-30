package com.example.wo.travelt.injector.component;

import android.app.Activity;
import android.content.Context;

import com.example.wo.travelt.injector.ContextLife;
import com.example.wo.travelt.injector.PerActivity;
import com.example.wo.travelt.injector.module.ActivityModule;
import com.example.wo.travelt.ui.activity.LoginActivity;

import dagger.Component;

/**
 * Created by freestar on 2016/11/2.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    @ContextLife("Application")
    Context getApplicationContext();

    @ContextLife("Activity")
    Context getActivityContext();

    void inject(LoginActivity loginActivity);
}
