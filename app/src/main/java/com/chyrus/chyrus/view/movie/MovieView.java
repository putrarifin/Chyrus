package com.chyrus.chyrus.view.movie;

import com.chyrus.chyrus.models.movie.MoviesResponse;

/**
 * Created by Chyrus on 5/24/17.
 */

public interface MovieView {

    void onCompleted();
    void onError(Throwable e);
    void onNext(MoviesResponse moviesResponse);

}
