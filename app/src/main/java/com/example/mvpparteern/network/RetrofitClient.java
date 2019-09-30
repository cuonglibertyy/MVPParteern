package com.example.mvpparteern.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static Service service;

    public static Service getService() {
        if (service == null) {
            new RetrofitClient();
        }
        return service;
    }

    private RetrofitClient() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)//quy dinh thoi gian client conect den server,qua thoi gian la huy
                .readTimeout(10, TimeUnit.SECONDS);//thoi gian tra du lieu ve

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constans.BASE_ETRANS_API_URL) //chi dinh phan dau api la gi
                .client(clientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()); //dung gson
        service = builder.build().create(Service.class);
    }
}
