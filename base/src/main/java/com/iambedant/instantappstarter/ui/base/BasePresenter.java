
package com.iambedant.instantappstarter.ui.base;

import com.iambedant.instantappstarter.data.DataManager;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.uber.rave.RaveException;

import java.io.IOException;
import java.net.SocketTimeoutException;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import okhttp3.ResponseBody;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private static final String TAG = "BasePresenter";

    private final DataManager mDataManager;

    private final CompositeDisposable mCompositeDisposable;

    private V mMvpView;

    @Inject
    public BasePresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        this.mDataManager = dataManager;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    @Override
    public void handleApiError(Throwable t) {
        //Handle Retrofit Error

        if (t instanceof HttpException) {
            ResponseBody responseBody = ((HttpException) t).response().errorBody();
            return;
            //Show Error
        } else if (t instanceof SocketTimeoutException) {
            //Show Timeout Error
            return;
        } else if (t instanceof IOException) {
            //Show Network Error
            return;
        }
        //Handle Rx Error

        //Handle Rave Error
        Throwable cause = t.getCause();
        if (cause instanceof RaveException) {
            //Show Error Message
            //TODO:: Show Different Message at Uat and Debug
            return;
        }
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    public void setUserAsLoggedOut() {

    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
