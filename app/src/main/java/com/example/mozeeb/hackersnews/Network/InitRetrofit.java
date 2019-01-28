package com.example.mozeeb.hackersnews.Network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitRetrofit {
    //URL SErver APi
    public static final String API_URL = "https://newsapi.org/v2/";

    public static ApiServices getAPIServices(){
        return RetrofitClient.getClient(API_URL).create(ApiServices.class);
    }


}
