package com.example.mvpparteern.network;

import com.example.mvpparteern.model.login.PostDetail;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Service {


    @POST("user/checkuserexist")
    Observable<PostDetail> login(@Body RequestBody body);
}
