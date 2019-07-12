package com.example.gagmvpwithdaggermaster.ui.news;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gagmvpwithdaggermaster.R;
import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.pojo.PojoTheNews;
import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.retrofit.Service;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class NewsActivity extends DaggerAppCompatActivity implements NewsContract.NewsView {
    @Inject
    NewsContract.NewsPresenter presenter;
    @Inject
    Service service;
    TextView innerTxtInfoTitle;
    TextView innerTxtInfoRightcol;
    TextView innerTxtAnnounce;
    ImageView innerImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        innerTxtInfoTitle = findViewById(R.id.innerTxtInfoTitle);
        innerTxtInfoRightcol = findViewById(R.id.innerTxtInfoRightcol);
        innerTxtAnnounce = findViewById(R.id.innerTxtAnnounce);
        innerImage = findViewById(R.id.innerImage);
    }
    public void getData(PojoTheNews.Example response){
        System.out.println(response +" data 1111!!!");
        Picasso.with(this).load(response.getTopic().getHeadline().getTitleImage().getUrl()).into(innerImage);
        innerTxtInfoTitle.setText(response.getTopic().getHeadline().getInfo().getTitle());
        innerTxtInfoRightcol.setText(response.getTopic().getHeadline().getInfo().getRightcol());
        innerTxtAnnounce.setText(response.getTopic().getHeadline().getInfo().getAnnounce());
    }
    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            String url = bundle.getString("url").substring(1);
            System.out.println(url);
            presenter.subscribe(url);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
    }
}