package com.example.wo.travelt.injector.module;

import android.app.Application;
import android.content.Context;

import com.android.library.util.PreferencesUtils;
import com.example.wo.travelt.constant.Preferences;
import com.example.wo.travelt.core.RetrofitService;
import com.example.wo.travelt.injector.ContextLife;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by freestar on 2016/11/2.
 */
@Module
public class ApplicationModule {
    Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    public Context provideContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    RetrofitService provideRetrofitService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(2, TimeUnit.SECONDS);

        String baseUrl = "http://192.168.1.199:8080/TravelApp/";
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(RetrofitService.class);
    }

    @Provides
    @Singleton
    String provideUserID() {
        return PreferencesUtils.getString(application, Preferences.USERID);
    }

}
