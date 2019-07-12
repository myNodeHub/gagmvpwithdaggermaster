package com.example.gagmvpwithdaggermaster.ui.main;


import android.content.Context;
import android.widget.Toast;

import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.pojo.PojoNewsLatestList;
import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.retrofit.Service;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PresenterImpl implements MainContract.Presenter {
    @Inject
    Context context;
    Service service;
    private MainContract.View view;

    public PresenterImpl(MainContract.View view, Service service) {
        this.view = view;
        this.service = service;
    }
    @Override
    public void subscribe() {
        service.getModelNewsLatest()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);
    }
    private void handleResults(PojoNewsLatestList pojoNewsLatestList) {
        if (pojoNewsLatestList != null) {
            view.setList(pojoNewsLatestList.getModelNewsLatestList());

        } else {
            Toast.makeText(context, "NO RESULTS FOUND",
                    Toast.LENGTH_LONG).show();
        }
    }
    private void handleError(Throwable t) {
        Toast.makeText(context, "ERROR IN FETCHING API RESPONSE. Try again",
                Toast.LENGTH_LONG).show();
    }
    @Override
    public void unsubscribe() {
    }
}
