package com.chyrus.chyrus.presenter.main;

import com.chyrus.chyrus.models.github.GithubResponse;
import com.chyrus.chyrus.services.ApiInteractor;
import com.chyrus.chyrus.view.main.MainView;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by Chyrus on 5/24/17.
 */

public class MainPresenterImp implements MainPresenter{

    ApiInteractor apiInteractor;
    Scheduler schedulers;
    MainView mainView;

    public MainPresenterImp(ApiInteractor apiInteractor, Scheduler schedulers, MainView mainView) {
        this.apiInteractor = apiInteractor;
        this.schedulers = schedulers;
        this.mainView = mainView;
    }

    @Override
    public Observable<GithubResponse> getResult(String username) {
        return apiInteractor.getGithubUser(username).observeOn(schedulers);
    }
}
