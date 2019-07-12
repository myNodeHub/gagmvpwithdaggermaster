package com.example.gagmvpwithdaggermaster.ui.main;

import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.pojo.PojoNewsLatest;

import java.util.List;

public interface MainContract {
    interface View {
       void setList(List<PojoNewsLatest> pojoNewsLatest);
    }
    interface Presenter  {
        void subscribe();
        void unsubscribe();
    }
}