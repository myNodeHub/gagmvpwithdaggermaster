package com.example.gagmvpwithdaggermaster;

import com.example.gagmvpwithdaggermaster.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MyApplication extends DaggerApplication{
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
