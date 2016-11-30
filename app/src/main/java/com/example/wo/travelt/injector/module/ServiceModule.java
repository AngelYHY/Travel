package com.example.wo.travelt.injector.module;

import android.app.Service;
import android.content.Context;
import com.example.wo.travelt.injector.ContextLife;
import com.example.wo.travelt.injector.PerService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by freestar on 2016/11/3.
 */
@Module
public class ServiceModule {
    private Service service;

    public ServiceModule(Service service) {
        this.service = service;
    }

    @Provides
    @PerService
    @ContextLife("Service")
    public Context provideContext() {
        return service;
    }

}
