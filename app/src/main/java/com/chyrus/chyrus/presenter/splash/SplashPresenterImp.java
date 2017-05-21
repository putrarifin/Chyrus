package com.chyrus.chyrus.presenter.splash;

import android.os.Handler;

import com.chyrus.chyrus.view.splash.SplashView;

/**
 * Created by Chyrus on 5/20/17.
 */

public class SplashPresenterImp implements SplashPresenter {

    SplashView view;

    public SplashPresenterImp(SplashView view) {
        this.view = view;
    }

    @Override
    public void waitSplash(int duration) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.showAlert();
                view.goMain();
            }
        },duration);
    }
}
