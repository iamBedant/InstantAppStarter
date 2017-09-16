package com.iambedant.instantappstarter.ui.newsSources

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.iambedant.instantappstarter.data.remote.model.newsSource.Source
import android.view.View
import android.view.ViewGroup
import com.iambedant.instantappstarter.featureone.R
import kotlinx.android.synthetic.main.rv_item_sources.view.*


/**
 * Created by @iamBedant on 16/09/17.
 */
class SourcesAdapter(datasource: List<Source>, listener: SourcesAdapter.OnItemClickListener) : RecyclerView.Adapter<SourcesAdapter.ViewHolder>() {

    val mDataSource: List<Source> = datasource
    val mListener: OnItemClickListener = listener

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(mDataSource[position], mListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.rv_item_sources, parent, false))
    }

    override fun getItemCount(): Int {
        return mDataSource.size
    }

    interface OnItemClickListener {
        fun onItemClick(item: Source)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Source, listener: OnItemClickListener) {
            with(item) {
                itemView.tv_name.text = name
                itemView.tv_category.text = category
                itemView.tv_description.text = description
                itemView.setOnClickListener { listener.onItemClick(this) }
            }
        }

    }
}