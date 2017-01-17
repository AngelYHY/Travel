package com.example.wo.travelt.injector.module;

import android.content.Context;

import com.example.wo.travelt.base.AppApplication;
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

    private final AppApplication mApplication;

    public ApplicationModule(AppApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    public Context provideContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    RetrofitService provideRetrofitService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(2, TimeUnit.SECONDS);
        //home
//        String baseUrl = "http://192.168.1.199:8080/TravelApp/";
        //other
        String baseUrl = "http://192.168.1.104:8080/TravelApp/";
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(RetrofitService.class);
    }

}
