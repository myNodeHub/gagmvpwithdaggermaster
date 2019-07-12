package com.example.gagmvpwithdaggermaster.di.main;

import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.retrofit.Service;
import com.example.gagmvpwithdaggermaster.ui.main.MainActivity;
import com.example.gagmvpwithdaggermaster.ui.main.MainContract;
import com.example.gagmvpwithdaggermaster.ui.main.PresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;


@Module
public abstract class MainActivityModule {
    @Binds
    public abstract MainContract.View view(MainActivity mainActivity);

    @Provides
    static MainContract.Presenter  provideAuthPresenter(MainContract.View view, Service service) {
        return new PresenterImpl(view, service);
    }
}
