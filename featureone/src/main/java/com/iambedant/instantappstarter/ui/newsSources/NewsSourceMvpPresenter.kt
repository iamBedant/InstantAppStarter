package com.iambedant.instantappstarter.ui.newsSources

import com.iambedant.instantappstarter.data.remote.model.newsSource.Source
import com.iambedant.instantappstarter.injection.PerActivity
import com.iambedant.instantappstarter.ui.base.MvpPresenter
import com.iambedant.instantappstarter.ui.thankyou.ThankYouMvpView

@PerActivity
interface NewsSourceMvpPresenter<V : NewsSourceMvpView> : MvpPresenter<V> {

    fun loadNewsSource()
    fun sourceClicked(item: Source)

}
