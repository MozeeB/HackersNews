package com.example.mozeeb.hackersnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mozeeb.hackersnews.DetailActivity;
import com.example.mozeeb.hackersnews.R;
import com.example.mozeeb.hackersnews.Response.ArticlesItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.MyViewHolder> {

    Context context;
    List<ArticlesItem>articlesItems;

    public AdapterBerita(Context context, List<ArticlesItem> articlesItems) {
        this.context = context;
        this.articlesItems = articlesItems;
    }

    @NonNull
    @Override
    public AdapterBerita.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_card, viewGroup ,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterBerita.MyViewHolder myViewHolder, final int i) {
        final String UrlGam = "" + articlesItems.get(i).getUrlToImage();
        Picasso.with(context).load(UrlGam).into(myViewHolder.gambar);

        myViewHolder.tvJudul.setText(articlesItems.get(i).getTitle());
        myViewHolder.tvTgl.setText(articlesItems.get(i).getPublishedAt());
        myViewHolder.tvPenerbit.setText(articlesItems.get(i).getAuthor());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, DetailActivity.class);
                in.putExtra("gambar", UrlGam);
                in.putExtra("judul", articlesItems.get(i).getTitle());
                in.putExtra("tgl", articlesItems.get(i).getPublishedAt());
                in.putExtra("penerbit", articlesItems.get(i).getAuthor());
                in.putExtra("artikel", articlesItems.get(i).getDescription());
            }
        });

    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //DEclarasi
        ImageView gambar;
        TextView tvJudul, tvTgl, tvPenerbit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            gambar = itemView.findViewById(R.id.ivPosterBerita);
            tvJudul = itemView.findViewById(R.id.tvJudulBerita);
            tvTgl = itemView.findViewById(R.id.tvTglTerbit);
            tvPenerbit = itemView.findViewById(R.id.tvPenulis);
        }
    }
}