package com.example.mozeeb.hackersnews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mozeeb.hackersnews.Network.ApiServices;
import com.example.mozeeb.hackersnews.Network.InitRetrofit;
import com.example.mozeeb.hackersnews.Response.ArticlesItem;
import com.example.mozeeb.hackersnews.Response.ResponseBerita;
import com.example.mozeeb.hackersnews.adapter.AdapterBerita;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        showBerita();

    }

    private void showBerita() {
        ApiServices api = InitRetrofit.getAPIServices();
        Call<ResponseBerita> call = api.request_show();

        call.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                if (response.isSuccessful()){
                    List<ArticlesItem> articlesItemList = response.body().getArticles();
                    AdapterBerita adapterBerita = new AdapterBerita(MainActivity.this, articlesItemList );

                    recycler.setHasFixedSize(true);
                    recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recycler.setAdapter(adapterBerita);
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {

            }
        });
    }
}
