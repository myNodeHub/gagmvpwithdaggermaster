package com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.retrofit;

import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.pojo.PojoNewsLatestList;
import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.pojo.PojoTheNews;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface Service {
    String BASE_URL = "http://api.lenta.ru/";
    @GET("lists/latest")
    Observable<PojoNewsLatestList> getModelNewsLatest();
    @Headers("Content-Type: application/json")
    @GET()
    Observable<PojoTheNews.Example> getTheNews(@Url String newslink);
}
