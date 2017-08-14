package com.iambedant.instantappstarter.ui.thankyou;

import com.iambedant.instantappstarter.data.DataManager;
import com.iambedant.instantappstarter.data.remote.model.UserRequest;
import com.iambedant.instantappstarter.data.remote.model.UserResponse;
import com.iambedant.instantappstarter.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by @iamBedant on 13/08/17.
 */

public class ThankYouPresenter<V extends ThankYouMvpView> extends BasePresenter<V>
        implements ThankyouMvpPresenter<V>{

    @Inject
    public ThankYouPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onHomeClicked() {
        UserRequest request = new UserRequest();
        getCompositeDisposable().add(getDataManager()
                .doLogin(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserResponse>() {
                    @Override
                    public void accept(UserResponse userResponse) throws Exception {
                        Timber.d(userResponse.getAadharReturnCode());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        handleApiError(throwable);
                    }
                }));
        getMvpView().openHomeActivity();
    }
}
