package com.example.gagmvpwithdaggermaster.ui.news;

import android.content.Context;
import android.widget.Toast;

import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.pojo.PojoTheNews;
import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.retrofit.Service;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewsPresenterImpl implements NewsContract.NewsPresenter{
    Context context;
    NewsContract.NewsView view;
    Service service;
    public NewsPresenterImpl(NewsContract.NewsView view, Service service, Context context) {
        this.view = view;
        this.service = service;
        this.context = context;
    }
    @Override
    public void subscribe(String url) {
            service.getTheNews(url)
                    .subscribeOn(Schedulers.computation())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResults, this::handleError);
        }
    private void handleResults(PojoTheNews.Example response) {
        view.getData(response);
    }
    private void handleError(Throwable t) {
        Toast.makeText(context, "ERROR IN FETCHING API RESPONSE.",
                Toast.LENGTH_LONG).show();
    }
    @Override
    public void unsubscribe() {
        //todo discard all async task
    }
}
