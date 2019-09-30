package com.example.mvpparteern.ui.splash.contracts;

import com.example.mvpparteern.base.BaseContract;

import com.example.mvpparteern.model.ErrorParser;
import com.example.mvpparteern.model.login.PostDetail;

public interface SplashContract {
    interface View extends BaseContract.BaseView {

        void showDeviceIdFirebase(String deviceId);

        void finishSaveDeviceIdSharedPreferences();

        void finishCheckDriverLoggedIn(boolean isDriverLoggedIn);

        void finishGetLastStatusDriver(PostDetail eTransJsonResult);

        void showLogin();

//        void showErrorLastStatus(ErrorParser errorParser, DataManager dataManager);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getDeviceIdFirebase();

        void saveDeviceIdSharedPreferences(String deviceId);

        void checkDriverLoggedIn();

        void getLastStatusDriver();
    }
}
