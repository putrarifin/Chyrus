package com.chyrus.chyrus.view.main;

import com.chyrus.chyrus.models.github.GithubResponse;

/**
 * Created by Chyrus on 5/21/17.
 */

public interface MainView {

    void onCompleted();
    void onError(Throwable e);
    void onNext(GithubResponse githubResponse);

}
