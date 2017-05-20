package com.chyrus.chyrus.presenter.splash;

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

    }
}
