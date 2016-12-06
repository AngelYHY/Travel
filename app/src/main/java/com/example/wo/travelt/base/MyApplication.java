package com.example.wo.travelt.base;

import android.app.Application;
import android.os.StrictMode;

import com.antfortune.freeline.FreelineCore;
import com.example.wo.travelt.injector.component.ApplicationComponent;
import com.example.wo.travelt.injector.component.DaggerApplicationComponent;
import com.example.wo.travelt.injector.module.ApplicationModule;
import com.rey.material.app.ThemeManager;
import com.squareup.leakcanary.LeakCanary;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

/**
 * Created by freestar on 2016/11/2.
 */

public class MyApplication extends Application {

    private ApplicationComponent component;
    private String accountName;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FreelineCore.init(this);
        ThemeManager.init(this, 2, 0, null);
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.injectApplication(this);

        enabledStrictMode();
        LeakCanary.install(this);
    }

    private void enabledStrictMode() {
        if (SDK_INT >= GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll() //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return component;
    }
}
