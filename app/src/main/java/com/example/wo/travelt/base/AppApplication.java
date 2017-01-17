package com.example.wo.travelt.base;

import android.app.Application;
import android.os.StrictMode;

import com.example.wo.travelt.injector.component.ApplicationComponent;
import com.example.wo.travelt.injector.module.ApplicationModule;
import com.rey.material.app.ThemeManager;
import com.squareup.leakcanary.LeakCanary;
import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

/**
 * Created by freestar on 2017/1/9 0009.
 */

public class AppApplication extends Application {

    private ApplicationComponent mComponent;
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
        ThemeManager.init(this, 2, 0, null);
        init();
    }

    private void init() {
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
//        this.component.injectApplication(this);
//        LeakCanary.install(this);
        enabledStrictMode();
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

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
