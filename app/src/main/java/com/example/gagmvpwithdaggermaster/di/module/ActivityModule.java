package com.example.gagmvpwithdaggermaster.di.module;

import com.example.gagmvpwithdaggermaster.ui.main.MainActivity;
import com.example.gagmvpwithdaggermaster.ui.news.NewsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityModule {
    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();
    @ContributesAndroidInjector
    abstract NewsActivity contributesNewsActivity();
}
