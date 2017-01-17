package com.example.wo.travelt.injector.component;

import android.content.Context;

import com.example.wo.travelt.base.AppApplication;
import com.example.wo.travelt.core.RetrofitService;
import com.example.wo.travelt.injector.ContextLife;
import com.example.wo.travelt.injector.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by freestar on 2016/11/2.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    AppApplication injectApplication(AppApplication application);

    @ContextLife("Application")
    Context getContext();

    RetrofitService getRetrofitService();
}
