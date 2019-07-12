package com.example.gagmvpwithdaggermaster;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gagmvpwithdaggermaster.pojoPlusRetrofit.pojo.PojoNewsLatest;
import com.example.gagmvpwithdaggermaster.ui.news.NewsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<PojoNewsLatest> listPojoNewsLatest;
    Context context;
    public RecyclerViewAdapter(Context context) {
        listPojoNewsLatest = new ArrayList<>();
        this.context= context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView card_view_image;
        public TextView txtInfoTitle;
        public TextView txtInfoRightcol;
        public CardView cardView;

        public ViewHolder(View view) {
            super(view);
            card_view_image = view.findViewById(R.id.card_view_image);
            txtInfoTitle = view.findViewById(R.id.txtInfoTitle);
            txtInfoRightcol = view.findViewById(R.id.txtInfoRightcol);
            cardView = view.findViewById(R.id.cardView);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_layout, parent, false);
        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final PojoNewsLatest theList = listPojoNewsLatest.get(position);
        if (theList.getTitleImage().getUrl() != null) {
        Picasso.with(context).load(theList.getTitleImage().getUrl()).into(holder.card_view_image);
    }
        holder.txtInfoTitle.setText(theList.getInfo().getTitle());
        holder.txtInfoRightcol.setText(theList.getInfo().getRightcol());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsActivity.class);
                intent.putExtra("url", theList.getInfo().getId());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return listPojoNewsLatest.size();
    }
    public void setData(List<PojoNewsLatest> data) {
        this.listPojoNewsLatest.addAll(data);
        notifyDataSetChanged();
    }
}
