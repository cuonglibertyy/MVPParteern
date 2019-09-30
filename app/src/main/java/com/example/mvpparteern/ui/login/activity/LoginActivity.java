package com.example.mvpparteern.ui.login.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvpparteern.Contract.Contract;
import com.example.mvpparteern.R;
import com.example.mvpparteern.base.BaseActivity;
import com.example.mvpparteern.model.login.PostDetail;
import com.example.mvpparteern.model.login.Results;
import com.example.mvpparteern.ui.login.presenter.LoginPresenter;
import com.example.mvpparteern.ui.login.contracts.LoginContract;
import com.google.gson.Gson;
import com.jakewharton.rxbinding3.view.RxView;
import com.novoda.merlin.Bindable;
import com.novoda.merlin.Connectable;
import com.novoda.merlin.Disconnectable;
import com.novoda.merlin.Merlin;
import com.novoda.merlin.NetworkStatus;

import javax.inject.Inject;

import butterknife.BindView;


public class LoginActivity extends BaseActivity implements LoginContract, View.OnClickListener, Connectable, Disconnectable, Bindable {
    @Inject
    LoginPresenter loginPresenter;
    private LoginContract mainView;
    @BindView(R.id.ed_phoneNumber)
    EditText ed_phoneNumber;
    @BindView(R.id.ed_deviceType)
    EditText ed_deviceType;
    @BindView(R.id.ed_stateCode)
    EditText ed_stateCode;
    @BindView(R.id.btn_login)
    Button btn_Login;
    String phoneNumber;



    public static void startActivity(Activity context) {
        context.startActivity(new Intent(context, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        context.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerConnectable(this);
        registerDisconnectable(this);
        registerBindable(this);
    }
    @Override
    public void onBind(NetworkStatus networkStatus) {
        if (!networkStatus.isAvailable()) {
            onDisconnect();
        }
    }

    @Override
    public void onConnect() {
//        loginPresenter.post(phoneNumber);
    }

    @Override
    public void onDisconnect() {
        Toast.makeText(this, "Ket nối thất bại", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void addEvents() {
        loginPresenter = new LoginPresenter(this,this);
        addDisposable(RxView.clicks(btn_Login)
                .subscribe(avoid -> {

                       phoneNumber = ed_phoneNumber.getText().toString();
                    Log.d("text", "phonenumber: "+phoneNumber);
                                loginPresenter.post(phoneNumber);

                        }, error -> {
                            Log.d("error", "addEvents: " + error);
                        }
                ));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showLogin() {

    }


    @Override
    public void OnSuccessful(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnResult(Results results) {
        Log.d("shdgfjshjf", "OnResult: " + new Gson().toJson(results));
    }


    @Override
    public void onClick(View v) {


    }


    @Override
    protected Merlin initMerlin() {
        return new Merlin.Builder()
                .withConnectableCallbacks()
                .withDisconnectableCallbacks()
                .withBindableCallbacks()
                .build(this);
    }

    @Override
    public void showError(int errorResId) {

    }

    @Override
    public void showError() {

    }

}
