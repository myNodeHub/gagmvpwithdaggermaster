package com.example.gagmvpwithdaggermaster.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gagmvpwithdaggermaster.R;
import com.example.gagmvpwithdaggermaster.RecyclerViewAdapter;
import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.pojo.PojoNewsLatest;
import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.retrofit.Service;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainContract.View {
    @Inject
    MainContract.Presenter presenter;
    @Inject
    RecyclerViewAdapter recyclerViewAdapter;
    @Inject
    Service service;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
    @Override
    public void setList(List<PojoNewsLatest> pojoNewsLatest) {
        recyclerViewAdapter.setData(pojoNewsLatest);
    }
    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
    }
}
