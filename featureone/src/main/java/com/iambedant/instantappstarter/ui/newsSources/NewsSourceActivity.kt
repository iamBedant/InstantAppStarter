package com.iambedant.instantappstarter.ui.newsSources

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.iambedant.instantappstarter.data.remote.model.newsSource.Source
import com.iambedant.instantappstarter.featureone.R
import com.iambedant.instantappstarter.ui.base.BaseActivityOne
import timber.log.Timber
import javax.inject.Inject
import android.content.Intent
import android.net.Uri
import kotlinx.android.synthetic.main.activity_news_source.*


class NewsSourceActivity : BaseActivityOne(), NewsSourceMvpView {

    override fun updateViewModel(sources: List<Source>) {
        rv_sources.adapter = SourcesAdapter(sources, object : SourcesAdapter.OnItemClickListener {
            override fun onItemClick(item: Source) {
                mPresenter.sourceClicked(item)
            }
        })
    }

    override fun launchDetails(url: String) {
        Timber.d(url)
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.addCategory(Intent.CATEGORY_BROWSABLE)
        intent.`package` = this.packageName
        this.startActivity(intent)
    }


    @Inject
    lateinit var mPresenter: NewsSourceMvpPresenter<NewsSourceMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        giveActivityComponent().inject(this)
        setContentView(R.layout.activity_news_source)
        mPresenter.onAttach(this)
        rv_sources.layoutManager = LinearLayoutManager(this)
        mPresenter.loadNewsSource()

    }
}
