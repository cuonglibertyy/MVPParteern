package com.example.mvpparteern.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.novoda.merlin.Bindable;
import com.novoda.merlin.Connectable;
import com.novoda.merlin.Disconnectable;
import com.novoda.merlin.Merlin;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseActivity extends RxAppCompatActivity {
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Merlin merlin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        context = this;

        addEvents();
        merlin = initMerlin();

    }

    protected abstract Merlin initMerlin();

    public abstract void showError(int errorResId);

    public abstract void showError();

    protected abstract void addEvents();

    protected abstract int getLayoutId();

    protected void registerConnectable(Connectable connectable) {
        merlin.registerConnectable(connectable);
    }
    protected  void registerDisconnectable(Disconnectable disconnectable){
        merlin.registerDisconnectable(disconnectable);
    }

    protected  void registerBindable(Bindable bindable){
        merlin.registerBindable(bindable);
    }

    protected void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    public abstract void showLogin();
}
