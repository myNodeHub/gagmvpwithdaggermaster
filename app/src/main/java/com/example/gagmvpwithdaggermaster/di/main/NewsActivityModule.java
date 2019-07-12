package com.example.gagmvpwithdaggermaster.di.main;

import android.content.Context;

import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.retrofit.Service;
import com.example.gagmvpwithdaggermaster.ui.news.NewsActivity;
import com.example.gagmvpwithdaggermaster.ui.news.NewsContract;
import com.example.gagmvpwithdaggermaster.ui.news.NewsPresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;


@Module
public abstract class NewsActivityModule {
    @Binds
    public abstract NewsContract.NewsView view(NewsActivity newsActivity);
    @Provides
    static NewsContract.NewsPresenter provideNewsPresenter(NewsContract.NewsView view, Service service, Context context){
        return new NewsPresenterImpl(view, service, context);
    }
}
