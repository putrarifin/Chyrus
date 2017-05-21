package com.chyrus.chyrus.services;

import com.chyrus.chyrus.models.GithubResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by Chyrus on 5/20/17.
 */

public class ApiInteractorImpl implements ApiInteractor{

    private ApiServices apiServices;
    private static HttpLoggingInterceptor interceptor = null;
    private static OkHttpClient client = null;

    public ApiInteractorImpl() {
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiList.getMainURL())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiServices = retrofit.create(ApiServices.class);
    }

    @Override
    public Observable<GithubResponse> getGithubUser(String username) {
        return apiServices.getGithubUser(username).subscribeOn(Schedulers.io());
    }
}
