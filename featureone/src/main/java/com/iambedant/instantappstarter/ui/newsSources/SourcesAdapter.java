package com.iambedant.instantappstarter.ui.newsSources;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iambedant.instantappstarter.data.remote.model.newsSource.Source;
import com.iambedant.instantappstarter.featureone.R;
import com.iambedant.instantappstarter.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @iamBedant on 22/08/17.
 */

public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.ViewHolder> {

    List<Source> mDataSource = new ArrayList<>();
    private final OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(Source item);
    }


    public SourcesAdapter(List<Source> datasource, OnItemClickListener listener) {
        this.mDataSource = datasource;
        this.mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_sources, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mDataSource.get(position), mListener);
    }


    @Override
    public int getItemCount() {

        return mDataSource.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mIvThumb;
        TextView mTvName;
        TextView mTvCategory;
        TextView mTvDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            mIvThumb = itemView.findViewById(R.id.iv_thumbnail);
            mTvName = itemView.findViewById(R.id.tv_name);
            mTvCategory = itemView.findViewById(R.id.tv_category);
            mTvDescription = itemView.findViewById(R.id.tv_description);
        }

        public void bind(final Source item, final OnItemClickListener listener) {
            mTvName.setText(item.getName());
            mTvCategory.setText(item.getCategory());
            mTvDescription.setText(item.getDescription());

            Glide.with(itemView.getContext()).load(CommonUtils.parseThumbnailUrl(item.getUrl())).into(mIvThumb);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    mListener.onItemClick(item);

                }

            });

        }
    }
}
