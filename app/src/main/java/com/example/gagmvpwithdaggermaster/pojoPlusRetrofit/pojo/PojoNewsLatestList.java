package com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PojoNewsLatestList {
    @SerializedName("headlines")
    @Expose
    private List<PojoNewsLatest> headlines;
    public List<PojoNewsLatest> getModelNewsLatestList() {
        return headlines;
    }
    public void setModelNewsLatestList(List<PojoNewsLatest> headlines) {
        this.headlines = headlines;
    }
}
