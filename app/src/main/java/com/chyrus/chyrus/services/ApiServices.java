package com.chyrus.chyrus.services;

import com.chyrus.chyrus.models.GithubResponse;
import rx.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chyrus on 5/20/17.
 */

public interface ApiServices {

    @GET("users/{username}")
    Observable<GithubResponse> getGithubUser(@Path("username") String username);

}
