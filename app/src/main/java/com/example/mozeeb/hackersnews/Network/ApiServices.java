package com.example.mozeeb.hackersnews.Network;

import com.example.mozeeb.hackersnews.Response.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("top-headlines?sources=hacker-news&apiKey=7659de32d86f41bfbf3864f433c6252b")
    Call<ResponseBerita> request_show();
}
