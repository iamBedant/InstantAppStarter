package com.iambedant.instantappstarter.ui.newsSources

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.iambedant.instantappstarter.data.remote.model.newsSource.Source
import com.iambedant.instantappstarter.featureone.R
import com.iambedant.instantappstarter.ui.base.BaseActivityOne
import timber.log.Timber
import javax.inject.Inject
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri


class NewsSourceActivity : BaseActivityOne(), NewsSourceMvpView {

    override fun updateViewModel(sources: List<Source>) {
        mRvSources.adapter = SourcesAdapter(sources, SourcesAdapter.OnItemClickListener {
            item ->mPresenter.sourceClicked(item)
        })
    }

    override fun launchDetails(url: String) {
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addCategory(Intent.CATEGORY_BROWSABLE)
        this.startActivity(intent)
    }


    private lateinit var mRvSources: RecyclerView

    @Inject
    lateinit var mPresenter: NewsSourceMvpPresenter<NewsSourceMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        giveActivityComponent().inject(this)
        setContentView(R.layout.activity_news_source)
        mRvSources = findViewById(R.id.rv_sources)
        mPresenter.onAttach(this)
        mRvSources.layoutManager = LinearLayoutManager(this)
        mPresenter.loadNewsSource()

    }
}
