package com.chyrus.chyrus;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.chyrus.chyrus.services.ApiInteractor;
import com.chyrus.chyrus.services.ApiInteractorImpl;

import butterknife.ButterKnife;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Chyrus on 5/20/17.
 */

public class BaseApps extends AppCompatActivity {

    protected CompositeSubscription subscription = new CompositeSubscription();
    protected ProgressDialog progressDialog;
    protected ApiInteractor interactor;
    protected Scheduler schedulers;

    protected void bind(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);

        interactor = new ApiInteractorImpl();
        schedulers = AndroidSchedulers.mainThread();
    }

    protected ApiInteractor getInteractor() {
        return interactor;
    }
    protected Scheduler getSchedulers() {
        return schedulers;
    }

    protected void showToastLong(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    protected void showToastShort(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }

    protected void showLoading(String message) {
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    protected void hideLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

}
