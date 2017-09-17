package com.iambedant.instantappstarter.ui.newslist

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.android.instantapps.InstantApps
import com.iambedant.instantappstarter.data.remote.model.newsList.Article
import com.iambedant.instantappstarter.featuretwo.R
import com.iambedant.instantappstarter.ui.base.BaseActivityTwo
import com.iambedant.instantappstarter.ui.newsSources.NewsListMvpPresenter
import com.iambedant.instantappstarter.ui.newsSources.NewsListMvpView
import kotlinx.android.synthetic.main.activity_news_list.*
import javax.inject.Inject


class NewsListActivity : BaseActivityTwo(), NewsListMvpView {


    val INSTANT_APPS_CODE = 1

    override fun showInstantAppDownloadButton() {
        ibtn_download.visibility = View.VISIBLE
    }
    override fun hideInstantAppDownloadButton() {
        ibtn_download.visibility = View.GONE
    }
    override fun updateViewModel(articles: List<Article>) {
        rv_news_list.adapter = NewsListAdapter(articles, object : NewsListAdapter.OnItemClickListener {
            override fun onItemClick(item: Article) {
                mPresenter.itemClicked(item)
            }
        })
        tv_source.text = articles[0].author
    }



    @Inject
    lateinit var mPresenter: NewsListMvpPresenter<NewsListMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        giveActivityComponent().inject(this)
        setContentView(R.layout.activity_news_list)
        mPresenter.onAttach(this)
        rv_news_list.layoutManager = LinearLayoutManager(this)
        handleApplink()
        mPresenter.handlePrompt(InstantApps.isInstantApp(this))
        ibtn_download.setOnClickListener {
            InstantApps.showInstallPrompt(this,INSTANT_APPS_CODE,"" )
        }
    }


    fun handleApplink() {
        if (intent?.data != null && intent.data.pathSegments.size > 0) {
            mPresenter.loadNewsList(intent.data.pathSegments[1])
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDetach()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
