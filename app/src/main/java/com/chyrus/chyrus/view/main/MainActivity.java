package com.chyrus.chyrus.view.main;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import com.chyrus.chyrus.BaseApps;
import com.chyrus.chyrus.R;
import com.chyrus.chyrus.models.github.GithubResponse;
import com.chyrus.chyrus.presenter.main.MainPresenter;
import com.chyrus.chyrus.presenter.main.MainPresenterImp;

import rx.Observer;

/**
 * Created by Chyrus on 5/21/17.
 */

public class MainActivity extends BaseApps implements MainView{

    private static final String TAG = "MainActivity";

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);

        mainPresenter = new MainPresenterImp(getInteractor(),getSchedulers(),this);
        if (isInternetConnectionAvailable()) {
            showLoading("Loading");
            subscription.add(mainPresenter.getResult("putrarifin")
                    .subscribe(this::onNext,this::onError,this::onCompleted));
        } else {
            showToastShort("Internet Issues");
        }
    }

    @Override
    public void onCompleted() {
        hideLoading();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onNext(GithubResponse githubResponse) {
        Log.d("nama", githubResponse.name);
    }
}
