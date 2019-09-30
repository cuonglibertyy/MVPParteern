package com.example.mvpparteern.ui.login.contracts;

import com.example.mvpparteern.model.login.PostDetail;
import com.example.mvpparteern.model.login.Results;

public interface LoginContract {

    void OnSuccessful(String message);
    void OnError(String message);
    void OnResult(Results results);

}
