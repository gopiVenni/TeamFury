package com.gogas.delivery.ui;

import android.app.Application;

import com.gogas.delivery.ui.service.SharedPref;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPref.init(this);
    }
}
