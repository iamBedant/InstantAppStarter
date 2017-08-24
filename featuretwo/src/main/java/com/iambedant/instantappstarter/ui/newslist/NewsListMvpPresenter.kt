package com.iambedant.instantappstarter.ui.newsSources

import com.iambedant.instantappstarter.injection.PerActivity
import com.iambedant.instantappstarter.ui.base.MvpPresenter
import com.iambedant.instantappstarter.ui.thankyou.ThankYouMvpView

@PerActivity
interface NewsListMvpPresenter<V : NewsListMvpView> : MvpPresenter<V> {

    fun loadNewsList(id:String)

}
