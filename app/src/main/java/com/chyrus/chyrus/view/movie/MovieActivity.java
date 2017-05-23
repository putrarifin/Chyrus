package com.chyrus.chyrus.view.movie;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chyrus.chyrus.BaseApps;
import com.chyrus.chyrus.BuildConfig;
import com.chyrus.chyrus.R;
import com.chyrus.chyrus.adapter.ListAdapter;
import com.chyrus.chyrus.adapter.vholders.MovieViewHolder;
import com.chyrus.chyrus.models.movie.Movie;
import com.chyrus.chyrus.models.movie.MoviesResponse;
import com.chyrus.chyrus.presenter.movie.MoviePresenter;
import com.chyrus.chyrus.presenter.movie.MoviePresenterImp;

import butterknife.BindView;

/**
 * Created by Chyrus on 5/22/17.
 */

public class MovieActivity extends BaseApps implements MovieView {

    private static final String TAG = "MovieActivity";
    MoviePresenter moviePresenter;
    @BindView(R.id.lst_movie)
    RecyclerView listMovie;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.movie_list);

        moviePresenter = new MoviePresenterImp(getInteractor(), getSchedulers(), this);

        if (isInternetConnectionAvailable()) {
            showLoading("get data");
            subscription.add(moviePresenter.getTopRatedMovies(BuildConfig.KEY_MOVIE)
                    .subscribe(this::onNext, this::onError, this::onCompleted));
        } else {
            showToastShort("Internet Issue!");
        }


    }

    @Override
    public void onCompleted() {
hideLoading();
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(MoviesResponse moviesResponse) {
        listMovie.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new ListAdapter<Movie, MovieViewHolder>(R.layout.list_item_movie, MovieViewHolder.class, Movie.class, moviesResponse.getResults()) {
            @Override
            protected void bindView(MovieViewHolder holder, Movie model, int position) {
                holder.bind(model.getTitle(), model.getReleaseDate(), model.getOverview(), model.getVoteAverage() + "");
            }
        };

        listMovie.setAdapter(listAdapter);
    }
}
