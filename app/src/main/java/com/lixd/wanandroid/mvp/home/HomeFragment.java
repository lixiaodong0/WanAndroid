package com.lixd.wanandroid.mvp.home;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lixd.wanandroid.R;
import com.lixd.wanandroid.adapter.HomeAdapter;
import com.lixd.wanandroid.base.BaseFragment;
import com.lixd.wanandroid.data.ArticleData;
import com.lixd.wanandroid.data.BannerData;

import java.util.List;

public class HomeFragment extends BaseFragment implements HomeContact.View {
    public static final String TAG = HomeFragment.class.getSimpleName();
    private RecyclerView mRecyHome;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private HomeAdapter mHomeAdapter;
    private int mPage = 0;

    public static final HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    private HomeContact.Presenter mPresenter;

    @Override
    protected Object getLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View rootView) {
        mSwipeRefreshLayout = rootView.findViewById(R.id.swipe_refresh_layout);
        mRecyHome = rootView.findViewById(R.id.recy_home);
        mRecyHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHomeAdapter = new HomeAdapter();
        mHomeAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getHomeData(mPage);
            }
        }, mRecyHome);
        mRecyHome.setAdapter(mHomeAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
        mPresenter.getHomeData(mPage);
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void showBannerData(List<BannerData> data) {

    }

    @Override
    public void showHomeData(List<ArticleData> data) {
        mPage++;
        mHomeAdapter.setNewData(data);
        Log.e("showHomeData", "page:" + mPage);
    }

    @Override
    public void showMoreHomeData(List<ArticleData> data) {
        mHomeAdapter.loadMoreComplete();
        mPage++;
        mHomeAdapter.addData(data);
        Log.e("showMoreHomeData", "page:" + mPage);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void setPresenter(HomeContact.Presenter presenter) {
        mPresenter = presenter;
    }
}
