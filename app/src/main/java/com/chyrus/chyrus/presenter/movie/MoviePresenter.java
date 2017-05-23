package com.chyrus.chyrus.presenter.movie;

import com.chyrus.chyrus.models.movie.MoviesResponse;
import com.chyrus.chyrus.services.ApiInteractor;

import rx.Observable;

/**
 * Created by Chyrus on 5/22/17.
 */

public interface MoviePresenter {

    Observable<MoviesResponse> getTopRatedMovies(String apiKey);
}
