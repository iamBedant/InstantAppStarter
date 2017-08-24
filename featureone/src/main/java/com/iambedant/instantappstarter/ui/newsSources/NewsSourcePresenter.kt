package com.iambedant.instantappstarter.ui.newsSources

import com.iambedant.instantappstarter.data.DataManager
import com.iambedant.instantappstarter.data.remote.model.newsSource.Source
import com.iambedant.instantappstarter.ui.base.BasePresenter
import com.iambedant.instantappstarter.utils.AppConstants

import javax.inject.Inject

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by @iamBedant on 13/08/17.
 */

class NewsSourcePresenter<V : NewsSourceMvpView> @Inject
constructor(dataManager: DataManager, compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(dataManager, compositeDisposable),
        NewsSourceMvpPresenter<V> {
    override fun sourceClicked(item: Source) {
        mvpView.launchDetails(AppConstants.ROOT_ENDPOINT+"/newslist/"+item.id)
    }

    override fun loadNewsSource() {
        compositeDisposable.add(dataManager
                .loadSources()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { sources -> mvpView.updateViewModel(sources.sources) },
                        { t -> handleApiError(t) }
                )
        )

    }
}
