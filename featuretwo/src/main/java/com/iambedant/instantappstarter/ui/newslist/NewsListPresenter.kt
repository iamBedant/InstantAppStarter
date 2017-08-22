package com.iambedant.instantappstarter.ui.newsSources

import com.iambedant.instantappstarter.data.DataManager
import com.iambedant.instantappstarter.data.remote.model.UserRequest
import com.iambedant.instantappstarter.data.remote.model.UserResponse
import com.iambedant.instantappstarter.ui.base.BasePresenter
import com.iambedant.instantappstarter.ui.thankyou.ThankYouMvpView
import com.iambedant.instantappstarter.ui.thankyou.ThankyouMvpPresenter

import javax.inject.Inject

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by @iamBedant on 13/08/17.
 */

class NewsListPresenter<V : NewsListMvpView> @Inject
constructor(dataManager: DataManager, compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(dataManager, compositeDisposable),
        NewsListMvpPresenter<V> {

    override fun loadNewsList() {


    }

}
