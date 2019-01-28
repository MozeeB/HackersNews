package com.example.mozeeb.hackersnews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_detail)
    ImageView ivDetail;
    @BindView(R.id.judul_detail)
    TextView judulDetail;
    @BindView(R.id.tgl_detail)
    TextView tglDetail;
    @BindView(R.id.oleh_detail)
    TextView olehDetail;
    @BindView(R.id.artikel_detail)
    TextView artikelDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Picasso.with(this).load(getIntent().getIntExtra("gambar",1)).into(ivDetail);



    }
}
