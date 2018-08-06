package com.lixd.wanandroid.adapter;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lixd.wanandroid.R;
import com.lixd.wanandroid.data.ClassifyData;

public class ProjectClassifyAdapter extends BaseQuickAdapter<ClassifyData, ProjectClassifyAdapter.ClassifyViewHolder> {


    public ProjectClassifyAdapter() {
        super(R.layout.project_classify_recycle_item);
    }

    @Override
    protected void convert(ClassifyViewHolder helper, ClassifyData item) {
        if (item.isSelected) {
            helper.mTvClassifyTitle.setTextColor(ContextCompat.getColor(mContext,R.color.colorPrimary));
        } else {
            helper.mTvClassifyTitle.setTextColor(Color.DKGRAY);
        }
        helper.mTvClassifyTitle.setText(item.name);
    }

    static class ClassifyViewHolder extends BaseViewHolder {
        private TextView mTvClassifyTitle;

        public ClassifyViewHolder(View view) {
            super(view);
            mTvClassifyTitle = view.findViewById(R.id.tv_classify_title);
        }
    }
}
