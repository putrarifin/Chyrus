package com.chyrus.chyrus.view.splash;

import android.content.Intent;
import android.os.Bundle;

import com.chyrus.chyrus.BaseApps;
import com.chyrus.chyrus.R;
import com.chyrus.chyrus.presenter.splash.SplashPresenter;
import com.chyrus.chyrus.presenter.splash.SplashPresenterImp;

/**
 * Created by Chyrus on 5/20/17.
 */

public class SplashActivity extends BaseApps implements SplashView {

    SplashPresenter splashPresenter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_splash);
        splashPresenter = new SplashPresenterImp(this);
        splashPresenter.waitSplash(5000);
    }

    @Override public void showAlert() {
        showToast("Hai, selamat datang!");
    }

    @Override public void goMain() {
        //go MainActivity
//        startActivity(new Intent(this, MainActivity.class));
//        finish();
    }

}
