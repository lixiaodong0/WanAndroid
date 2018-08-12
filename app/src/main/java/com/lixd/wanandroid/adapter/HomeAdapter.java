package com.lixd.wanandroid.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lixd.wanandroid.R;
import com.lixd.wanandroid.data.ArticleData;

public class HomeAdapter extends BaseQuickAdapter<ArticleData, HomeAdapter.HomeViewHolder> {

    public HomeAdapter() {
        super(R.layout.home_recy_item);
    }

    @Override
    protected void convert(HomeViewHolder helper, ArticleData item) {
        helper.mTvPublishTime.setText(item.niceDate);
        helper.mTvArticleTitle.setText(item.title);
        helper.mTvAuthor.setText(item.author);
    }

    static class HomeViewHolder extends BaseViewHolder {

        private final ImageView mImgUserIcon;
        private final TextView mTvAuthor;
        private final TextView mTvPublishTime;
        private final TextView mTvArticleTitle;

        public HomeViewHolder(View view) {
            super(view);
            mImgUserIcon = view.findViewById(R.id.img_user_icon);
            mTvAuthor = view.findViewById(R.id.tv_author);
            mTvPublishTime = view.findViewById(R.id.tv_publish_time);
            mTvArticleTitle = view.findViewById(R.id.tv_article_title);
        }
    }
}
