package com.iambedant.instantappstarter.ui.newslist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.iambedant.instantappstarter.data.remote.model.newsList.Article
import com.iambedant.instantappstarter.featuretwo.R
import com.iambedant.instantappstarter.ui.base.BaseActivityTwo
import com.iambedant.instantappstarter.ui.newsSources.NewsListMvpPresenter
import com.iambedant.instantappstarter.ui.newsSources.NewsListMvpView
import timber.log.Timber
import javax.inject.Inject



class NewsListActivity : BaseActivityTwo(),NewsListMvpView {

    override fun updateViewModel(articles: List<Article>) {
        mRvNewsList.adapter = NewsListAdapter(articles, object : NewsListAdapter.OnItemClickListener {
            override fun onItemClick(item: Article) {
                //TODO Launch News Url
            }
        })
    }

    private lateinit var mRvNewsList: RecyclerView

    @Inject
    lateinit var mPresenter: NewsListMvpPresenter<NewsListMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        giveActivityComponent().inject(this)
        setContentView(R.layout.activity_news_list)
        mRvNewsList = findViewById(R.id.rv_news_list)
        mPresenter.onAttach(this)
        mRvNewsList.layoutManager = LinearLayoutManager(this)

        handleApplink()
    }


    fun handleApplink(){
        if(intent?.data!=null && intent.data.pathSegments.size>0){
            mPresenter.loadNewsList(intent.data.pathSegments[1])
        }
    }
}
