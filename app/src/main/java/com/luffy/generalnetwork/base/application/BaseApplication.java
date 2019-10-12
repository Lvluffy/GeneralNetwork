package com.luffy.generalnetwork.base.application;

import android.app.Application;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 公用的Application
 */
public class BaseApplication extends Application {

    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
