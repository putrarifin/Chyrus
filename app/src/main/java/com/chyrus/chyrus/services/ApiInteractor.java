package com.chyrus.chyrus.services;

import com.chyrus.chyrus.models.GithubResponse;

import rx.Observable;


/**
 * Created by Chyrus on 5/21/17.
 */

public interface ApiInteractor {

    Observable<GithubResponse> getGithubUser(String username);

}
