package com.iambedant.instantappstarter.ui.newsSources
import com.iambedant.instantappstarter.data.DataManager
import com.iambedant.instantappstarter.ui.base.BasePresenter
import javax.inject.Inject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import com.iambedant.instantappstarter.data.remote.model.newsList.Article
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


/**
 * Created by @iamBedant on 13/08/17.
 */

class NewsListPresenter<V : NewsListMvpView> @Inject
constructor(dataManager: DataManager, compositeDisposable: CompositeDisposable)
    : BasePresenter<V>(dataManager, compositeDisposable),
        NewsListMvpPresenter<V> {
    override fun itemClicked(item: Article) {
        mvpView.onError("Demo App. Not doing Anything")
    }

    override fun handlePrompt(instantApp: Boolean) {

        if (instantApp) {
            mvpView.showInstantAppDownloadButton()
        }else{
            mvpView.hideInstantAppDownloadButton()
        }
    }

    override fun loadNewsList(id: String) {
        mvpView.showLoading()
        compositeDisposable.add(dataManager.loadNews(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { list ->
                            run {
                                mvpView.hideLoading()
                                mvpView.updateViewModel(list.articles)
                            }
                        },
                        { t ->
                            run {
                                mvpView.hideLoading()
                                handleApiError(t)
                            }
                        }
                )
        )


    }


}
