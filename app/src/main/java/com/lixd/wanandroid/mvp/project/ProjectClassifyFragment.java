package com.lixd.wanandroid.mvp.project;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lixd.wanandroid.R;
import com.lixd.wanandroid.adapter.ProjectClassifyAdapter;
import com.lixd.wanandroid.base.BaseFragment;
import com.lixd.wanandroid.data.ClassifyData;

import java.util.List;

public class ProjectClassifyFragment extends BaseFragment implements ProjectClassifyContract.View {
    public static final String TAG = ProjectClassifyFragment.class.getSimpleName();
    private RecyclerView mRecyClassify;
    private ProjectClassifyAdapter mProjectClassifyAdapter;
    private ProjectClassifyContract.Presenter mPresenter;

    public static final ProjectClassifyFragment newInstance() {
        ProjectClassifyFragment projectClassifyFragment = new ProjectClassifyFragment();
        return projectClassifyFragment;
    }

    @Override
    protected Object getLayout() {
        return R.layout.project_classify_fragment;
    }

    @Override
    protected void initView(View rootView) {
        mRecyClassify = rootView.findViewById(R.id.recy_classify);
        mRecyClassify.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyClassify.setHasFixedSize(true);
        mProjectClassifyAdapter = new ProjectClassifyAdapter();
        mRecyClassify.setAdapter(mProjectClassifyAdapter);
    }

    @Override
    protected void initEvent() {
        mProjectClassifyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                List<ClassifyData> dataList = mProjectClassifyAdapter.getData();
                int count = dataList.size();
                for (int i = 0; i < count; i++) {
                    ClassifyData classifyData = dataList.get(i);
                    if (i == position) {
                        classifyData.isSelected = true;
                    } else {
                        classifyData.isSelected = false;
                    }
                }
                mProjectClassifyAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showProjectClassifyData(List<ClassifyData> data) {
        mProjectClassifyAdapter.setNewData(data);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT);
    }

    @Override
    public void setPresenter(ProjectClassifyContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.unsubscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }
}
