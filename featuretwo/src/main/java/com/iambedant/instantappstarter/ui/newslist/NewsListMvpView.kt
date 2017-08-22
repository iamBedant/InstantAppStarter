package com.iambedant.instantappstarter.ui.newsSources


import com.iambedant.instantappstarter.data.remote.model.newsList.Article
import com.iambedant.instantappstarter.data.remote.model.newsSource.Source
import com.iambedant.instantappstarter.ui.base.MvpView


interface NewsListMvpView : MvpView {

    fun updateViewModel(articles:List<Article>)
}
