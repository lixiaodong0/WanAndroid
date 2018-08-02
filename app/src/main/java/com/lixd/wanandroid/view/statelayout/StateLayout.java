package com.lixd.wanandroid.view.statelayout;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.lixd.wanandroid.R;

/**
 * 状态布局
 * 成功状态
 * 网络错误状态
 * 空数据状态
 */
public abstract class StateLayout extends FrameLayout {

    private ViewStub emptyLayout;
    private ViewStub errorLayout;

    private RelativeLayout rlContentLayout;
    private RelativeLayout rlEmptyLayout;
    private RelativeLayout rlErrorLayout;

    private LayoutInflater layoutInflater;

    public StateLayout(@NonNull Context context) {
        super(context, null);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public StateLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.state_layout, this);
        layoutInflater = LayoutInflater.from(context);
        init();

    }

    private void init() {
        rlContentLayout = findViewById(R.id.rl_content_layout);
        emptyLayout = findViewById(R.id.state_empty_layout);
        errorLayout = findViewById(R.id.state_network_error_layout);
    }

    public void showEmptyLayout() {
        if (viewstubIsInflate(emptyLayout)) {
            return;
        }
        emptyLayout.inflate();
        rlEmptyLayout = findViewById(R.id.rl_empty_layout);
    }

    public void showErrorLayout() {
        if (viewstubIsInflate(errorLayout)) {
            return;
        }
        errorLayout.inflate();
        rlErrorLayout = findViewById(R.id.rl_error_layout);
    }


    private void hideErrorLayout() {
        if (viewstubIsInflate(errorLayout) && rlErrorLayout != null && rlErrorLayout.getVisibility() == View.VISIBLE) {
            rlErrorLayout.setVisibility(View.GONE);
        }
    }

    private void hideEmptyLayout() {
        if (viewstubIsInflate(emptyLayout) && rlEmptyLayout != null && rlEmptyLayout.getVisibility() == View.VISIBLE) {
            rlEmptyLayout.setVisibility(View.GONE);
        }
    }

    public void showContentLayout() {
        if (rlContentLayout != null && rlContentLayout.getVisibility() != View.VISIBLE) {
            rlContentLayout.setVisibility(View.VISIBLE);
        }
        hideEmptyLayout();
        hideErrorLayout();

        if (getContentLayoutId() != 0) {
            throw new RuntimeException("getContentLayoutId not found");
        }
        View contentView = layoutInflater.inflate(getContentLayoutId(), rlContentLayout, false);
        rlContentLayout.addView(contentView);
    }

    @LayoutRes
    protected abstract int getContentLayoutId();

    /**
     * 判断ViewStub是否初始化过
     * viewStub.getParent(), 如果初始化过,返回为null
     */
    private boolean viewstubIsInflate(ViewStub viewStub) {
        return viewStub.getParent() == null ? true : false;
    }
}
