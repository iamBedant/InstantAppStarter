package com.iambedant.instantappstarter.ui.newslist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.iambedant.instantappstarter.data.remote.model.newsList.Article
import com.iambedant.instantappstarter.featuretwo.R

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
        holder?.bind(mDataSource.get(position), mListner)
    }


    interface OnItemClickListener {
        fun onItemClick(item: Article)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var mTvTitle: TextView = itemView.findViewById(R.id.tv_title)
        private var mIvCover: ImageView = itemView.findViewById(R.id.iv_cover)
        private var mTvAuthor: TextView = itemView.findViewById(R.id.tv_author)
        private var mTvDate: TextView = itemView.findViewById(R.id.tv_date)
        private var mTvDescription: TextView = itemView.findViewById(R.id.tv_description)

        fun bind(article: Article, mListener: OnItemClickListener) {
            mTvTitle.text = article.title
            mTvDescription.text = article.description
            mTvAuthor.text = article.author
            mTvDate.text = article.publishedAt
            Glide.with(itemView.context).load(article.urlToImage).into(mIvCover)
            itemView.setOnClickListener { mListener.onItemClick(article) }
        }


    }
}