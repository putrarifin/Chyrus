package com.chyrus.chyrus.view.main;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import com.chyrus.chyrus.BaseApps;
import com.chyrus.chyrus.R;
import com.chyrus.chyrus.models.GithubResponse;

/**
 * Created by Chyrus on 5/21/17.
 */

public class MainActivity extends BaseApps {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);

        if (isInternetConnectionAvailable()) {
            showLoading("Loading");
            Log.d(TAG, "onCreate: boom");
            subscription.add(getInteractor().getGithubUser("putrarifin").observeOn(getSchedulers()).subscribe(new rx.Observer<GithubResponse>() {
                @Override
                public void onCompleted() {
                    hideLoading();
                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                }

                @Override
                public void onNext(GithubResponse githubResponse) {
                    Log.d("nama", githubResponse.name);
                }

            }));
        } else {
            showToastShort("Internet Issues");
        }
    }

    private boolean isInternetConnectionAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork.isConnectedOrConnecting();
    }

}
