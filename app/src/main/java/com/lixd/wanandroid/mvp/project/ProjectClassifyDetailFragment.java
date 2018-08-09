package com.lixd.wanandroid.mvp.project;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lixd.wanandroid.R;
import com.lixd.wanandroid.adapter.ProjectClassifyDetailAdapter;
import com.lixd.wanandroid.base.BaseFragment;
import com.lixd.wanandroid.data.ClassifyDetailData;

import java.util.List;

public class ProjectClassifyDetailFragment extends BaseFragment implements ProjectClassifyDetailContract.View {
    public static final String TAG = ProjectClassifyDetailFragment.class.getSimpleName();
    private static final String CID_KEY = "CID";
    private RecyclerView mRecyClassifyDetail;
    private ProjectClassifyDetailAdapter mProjectClassifyDetailAdapter;
    private ProjectClassifyDetailContract.Presenter mPresenter;
    private int mPage = 1;
    private int mCid;

    public static final ProjectClassifyDetailFragment newInstance(int cid) {
        ProjectClassifyDetailFragment fragment = new ProjectClassifyDetailFragment();
        Bundle args = new Bundle();
        args.putInt(CID_KEY, cid);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected Object getLayout() {
        return R.layout.project_classify_detail_fragment;
    }

    @Override
    protected void initView(View rootView) {
        mRecyClassifyDetail = rootView.findViewById(R.id.recy_classify_detail);
        mRecyClassifyDetail.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mProjectClassifyDetailAdapter = new ProjectClassifyDetailAdapter();
        mRecyClassifyDetail.setAdapter(mProjectClassifyDetailAdapter);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mPresenter = (ProjectClassifyDetailContract.Presenter) savedInstanceState.getSerializable("presenter");
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            mCid = arguments.getInt(CID_KEY);
            if (mPresenter != null) {
                mPresenter.getProjectClassifyDetail(mPage, mCid);
            }
        }
    }

    @Override
    public void showProjectClassifyDetail(List<ClassifyDetailData.Project> data) {
        mProjectClassifyDetailAdapter.setNewData(data);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(ProjectClassifyDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null) {
            outState.putSerializable("presenter", mPresenter);
        }
    }
}
