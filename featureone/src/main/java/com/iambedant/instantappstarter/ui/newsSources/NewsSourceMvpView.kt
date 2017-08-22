package com.iambedant.instantappstarter.ui.newsSources


import com.iambedant.instantappstarter.data.remote.model.newsSource.Source
import com.iambedant.instantappstarter.ui.base.MvpView


interface NewsSourceMvpView : MvpView {

    fun updateViewModel(sources: List<Source>)
    fun launchDetails(url: String)
}
