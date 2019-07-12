package com.example.gagmvpwithdaggermaster.di;

import android.app.Application;

import com.example.gagmvpwithdaggermaster.di.module.RecyclerViewAdapterModule;
import com.example.gagmvpwithdaggermaster.di.module.RetrofitModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityBindingsModule.class, RetrofitModule.class,
                                                                                    RecyclerViewAdapterModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    @Override
    void inject(DaggerApplication instance);
    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);
        AppComponent build();
    }
}
