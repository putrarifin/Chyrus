package com.chyrus.chyrus.presenter.movie;

import com.chyrus.chyrus.models.movie.MoviesResponse;
import com.chyrus.chyrus.services.ApiInteractor;
import com.chyrus.chyrus.view.movie.MovieView;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by Chyrus on 5/22/17.
 */

public class MoviePresenterImp implements MoviePresenter {

    private ApiInteractor apiInteractor;
    private Scheduler schedulers;
    private MovieView movieView;

    public MoviePresenterImp(ApiInteractor apiInteractor, Scheduler schedulers, MovieView movieView) {
        this.apiInteractor = apiInteractor;
        this.schedulers = schedulers;
        this.movieView = movieView;
    }

    @Override
    public Observable<MoviesResponse> getTopRatedMovies(String apiKey) {
        return apiInteractor.getTopRatedMovies(apiKey).observeOn(schedulers);
    }
}
