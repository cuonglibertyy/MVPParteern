package com.example.mvpparteern.ui.splash.activity;


import android.widget.Button;

import com.example.mvpparteern.R;
import com.example.mvpparteern.base.BaseActivity;
import com.example.mvpparteern.model.login.PostDetail;
import com.example.mvpparteern.ui.login.activity.LoginActivity;
import com.example.mvpparteern.ui.splash.contracts.SplashContract;
import com.example.mvpparteern.ui.splash.presenter.SplashPresenter;
import com.example.mvpparteern.utils.ToastUtils;
import com.example.mvpparteern.widget.LoadingDialog;
import com.novoda.merlin.Bindable;
import com.novoda.merlin.Connectable;
import com.novoda.merlin.Disconnectable;
import com.novoda.merlin.Merlin;
import com.novoda.merlin.NetworkStatus;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends BaseActivity implements SplashContract.View, Connectable, Disconnectable, Bindable {

    @BindView(R.id.btn_login)
    Button btn_Login;
    @Inject
    SplashPresenter presenter;

    @Override
    protected Merlin initMerlin() {
        return null;
    }


    @Override
    public void showProgress(boolean show) {
        if (show) {
            LoadingDialog.getInstance().showLoading(this);
        } else {
            LoadingDialog.getInstance().hideLoading();
        }
    }

    @Override
    public void showError(int errorResId) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void onComplete() {

    }


    @Override
    protected void addEvents() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onBind(NetworkStatus networkStatus) {

    }

    @Override
    public void onConnect() {

    }

    @Override
    public void showDeviceIdFirebase(String deviceId) {

    }

    @Override
    public void finishSaveDeviceIdSharedPreferences() {

    }

    @Override
    public void finishCheckDriverLoggedIn(boolean isDriverLoggedIn) {

    }

    @Override
    public void finishGetLastStatusDriver(PostDetail eTransJsonResult) {

    }

    @Override
    public void showLogin() {
        addDisposable(Observable.just(0).delay(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aVoid -> {
                    openLoginScreen();
                }));
    }

    private void openLoginScreen() {

        LoginActivity.startActivity(this);
        finish();
    }


    @Override
    public void onDisconnect() {

    }
}
