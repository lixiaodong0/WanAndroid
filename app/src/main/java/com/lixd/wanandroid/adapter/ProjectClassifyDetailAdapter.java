package com.lixd.wanandroid.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lixd.wanandroid.R;
import com.lixd.wanandroid.data.ArticleData;
import com.lixd.wanandroid.util.ImageUtil;

public class ProjectClassifyDetailAdapter extends BaseQuickAdapter<ArticleData, ProjectClassifyDetailAdapter.ProjectClassifyDetailViewHolder> {

    public ProjectClassifyDetailAdapter() {
        super(R.layout.project_classify_detail_recycle_item);
    }

    @Override
    protected void convert(ProjectClassifyDetailViewHolder helper, ArticleData item) {
        ImageUtil.loadImage(mContext, helper.mImgProjectIcon, item.envelopePic);
        helper.mTvAuthor.setText(item.author);
        helper.mTvProjectDate.setText(item.niceDate);
        helper.mTvProjectTitle.setText(item.title);
    }

    static class ProjectClassifyDetailViewHolder extends BaseViewHolder {
        private ImageView mImgProjectIcon;
        private final ImageView mImgUserIcon;
        private final TextView mTvAuthor;
        private final TextView mTvProjectTitle;
        private final TextView mTvProjectDate;

        public ProjectClassifyDetailViewHolder(View view) {
            super(view);
            mImgProjectIcon = view.findViewById(R.id.img_projcet_icon);
            mImgUserIcon = view.findViewById(R.id.img_user_icon);
            mTvAuthor = view.findViewById(R.id.tv_author);
            mTvProjectTitle = view.findViewById(R.id.tv_project_title);
            mTvProjectDate = view.findViewById(R.id.tv_project_date);
        }
    }
}
