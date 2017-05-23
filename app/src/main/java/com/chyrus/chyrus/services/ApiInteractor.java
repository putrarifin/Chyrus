package com.chyrus.chyrus.services;

import com.chyrus.chyrus.models.github.GithubResponse;
import com.chyrus.chyrus.models.movie.MoviesResponse;

import rx.Observable;


/**
 * Created by Chyrus on 5/21/17.
 */

public interface ApiInteractor {

    Observable<GithubResponse> getGithubUser(String username);
    Observable<MoviesResponse> getTopRatedMovies(String apiKey);
    Observable<MoviesResponse> getMovieDetails(int id,String apiKey);

}
