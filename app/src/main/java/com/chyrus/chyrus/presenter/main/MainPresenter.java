package com.chyrus.chyrus.presenter.main;


import com.chyrus.chyrus.models.github.GithubResponse;

import rx.Observable;

/**
 * Created by Chyrus on 5/24/17.
 */

public interface MainPresenter {

    Observable<GithubResponse> getResult(String username);
}
