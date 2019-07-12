package com.example.gagmvpwithdaggermaster.di;

import com.example.gagmvpwithdaggermaster.di.main.MainActivityModule;
import com.example.gagmvpwithdaggermaster.di.main.NewsActivityModule;
import com.example.gagmvpwithdaggermaster.di.scopes.PerActivity;
import com.example.gagmvpwithdaggermaster.ui.main.MainActivity;
import com.example.gagmvpwithdaggermaster.ui.news.NewsActivity;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

@Module(includes = AndroidInjectionModule.class)
abstract class ActivityBindingsModule {
    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();
    @PerActivity
    @ContributesAndroidInjector(modules = NewsActivityModule.class)
    abstract NewsActivity newsActivityInjector();
}

