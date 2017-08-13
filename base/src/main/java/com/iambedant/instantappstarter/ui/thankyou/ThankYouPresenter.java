package com.iambedant.instantappstarter.ui.thankyou;

import com.iambedant.instantappstarter.data.DataManager;
import com.iambedant.instantappstarter.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

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
        getMvpView().openHomeActivity();
    }
}
