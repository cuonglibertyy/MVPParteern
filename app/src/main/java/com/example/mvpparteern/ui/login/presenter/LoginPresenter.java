package com.example.mvpparteern.ui.login.presenter;

import android.content.Context;
import android.util.Log;

import com.example.mvpparteern.Contract.Contract;
import com.example.mvpparteern.model.login.PostDetail;
import com.example.mvpparteern.model.login.Results;
import com.example.mvpparteern.network.Constans;
import com.example.mvpparteern.network.RetrofitClient;
import com.example.mvpparteern.ui.login.contracts.LoginContract;
import com.example.mvpparteern.ui.login.activity.LoginActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class LoginPresenter {
    private Context context;
   private CompositeDisposable compositeDisposable = new CompositeDisposable();


    private LoginContract loginContract;
    private String TAG = "data";

    public LoginPresenter(LoginActivity view, LoginContract loginContract) {
        this.context = context;
        this.loginContract = loginContract;
    }



    public void post(String phoneNumber) {

        Map<String, String> jsonParams = new HashMap<>();
        jsonParams.put(Constans.KEY_LOGIN_PHONENUMBER, phoneNumber);
        jsonParams.put(Constans.KEY_LOGIN_STATE_CODE,Constans.KEY_RELIGION_NATION_VN);
        jsonParams.put(Constans.KEY_LOGIN_DEVICE_TYPE, Constans.KEY_DEVICETYPE);

        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), (new JSONObject(jsonParams)).toString());




      Disposable disposable = RetrofitClient.getService().login(body)
                .flatMap(postDetail -> Observable.just(postDetail.getResults()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(result -> {
                    loginContract.OnSuccessful(Contract.successfull);
                    loginContract.OnResult(result);
                    Log.d("list ", "Result: " + result.toString());
                }, e -> {
                    Log.d(TAG, "post: "+e);
                    loginContract.OnError(Contract.error);
                });
      compositeDisposable.add(disposable);
    }



}
