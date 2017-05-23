package com.chyrus.chyrus.services;

import com.chyrus.chyrus.models.github.GithubResponse;
import com.chyrus.chyrus.models.movie.MoviesResponse;

import retrofit2.http.Query;
import rx.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chyrus on 5/20/17.
 */

/*Take a look to other annotations:

@Path – variable substitution for the API endpoint. For example movie id will be swapped for{id} in the URL endpoint.

@Query – specifies the query key name with the value of the annotated parameter.

@Body – payload for the POST call

@Header – specifies the header with the value of the annotated parameter*/

public interface ApiServices {

    @GET("users/{username}")
    Observable<GithubResponse> getGithubUser(@Path("username") String username);

    @GET("movie/top_rated")
    Observable<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Observable<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
