package com.example.mvpparteern.base;

import androidx.annotation.StringRes;

public interface BaseContract {
    interface BaseView {
        void showProgress(boolean show);

        void showError(@StringRes int stringResId);

        void showError();

        void onComplete();
    }

    interface BasePresenter<T> {
        void attachView(T view);

        void detachView();
    }
}
