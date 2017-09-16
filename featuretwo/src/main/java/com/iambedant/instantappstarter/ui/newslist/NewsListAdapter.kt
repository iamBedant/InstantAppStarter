package com.iambedant.instantappstarter.ui.newslist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.iambedant.instantappstarter.data.remote.model.newsList.Article
import com.iambedant.instantappstarter.featuretwo.R
import kotlinx.android.synthetic.main.rv_item_news.view.*

/**
 * Created by @iamBedant on 22/08/17.
 */
class NewsListAdapter(datasource: List<Article>, listener: OnItemClickListener) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    val mDataSource: List<Article> = datasource
    val mListner: OnItemClickListener = listener


    override fun getItemCount(): Int {
        return mDataSource.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.rv_item_news, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(mDataSource[position], mListner)
    }


    interface OnItemClickListener {
        fun onItemClick(item: Article)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article, mListener: OnItemClickListener) {
            with(article) {
                itemView.tv_title.text = title
                itemView.tv_description.text = description
                itemView.tv_author.text = author
                itemView.tv_date.text = publishedAt
                Glide.with(itemView.context).load(urlToImage).into(itemView.iv_cover)
                itemView.setOnClickListener { mListener.onItemClick(this) }
            }
        }
    }
}