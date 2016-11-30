package com.example.wo.travelt.injector.module;

import android.app.Activity;
import android.content.Context;

import com.example.wo.travelt.injector.ContextLife;
import com.example.wo.travelt.injector.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by freestar on 2016/11/2.
 */
@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    public Context provideContext() {
        return activity;
    }
}
