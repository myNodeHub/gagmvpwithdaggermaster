package com.example.gagmvpwithdaggermaster.ui.news;

import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.pojo.PojoTheNews;


public interface NewsContract {
    interface NewsView{
        void getData(PojoTheNews.Example response);
    }
    interface NewsPresenter{
        void subscribe(String url);
        void unsubscribe();
    }
}
