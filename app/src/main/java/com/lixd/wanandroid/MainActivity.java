package com.lixd.wanandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lixd.wanandroid.base.BaseActivity;
import com.lixd.wanandroid.data.source.ProjectClassifyPepository;
import com.lixd.wanandroid.data.source.remote.ProjectClassifyRemoteDataSource;
import com.lixd.wanandroid.mvp.home.HomeFragment;
import com.lixd.wanandroid.mvp.project.ProjectClassifyFragment;
import com.lixd.wanandroid.mvp.project.ProjectClassifyPresenter;
import com.lixd.wanandroid.mvp.recreation.RecreationFragment;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private BottomNavigationView mBottomNavigationView;
    private HomeFragment mHomeFragment;
    private ProjectClassifyFragment mProjectClassifyFragment;
    private RecreationFragment mRecreationFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    protected void initView() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToolbar = findViewById(R.id.toolbar);
        initToolbar(mToolbar);
        mNavigationView = findViewById(R.id.navigation_view);
        mBottomNavigationView = findViewById(R.id.mian_bottom_view);
    }

    private void initToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            //设置左上角的图标响应
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            //创建监听器
            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
            //同步状态
            drawerToggle.syncState();
            //侧边栏绑定监听器
            mDrawerLayout.addDrawerListener(drawerToggle);
        }
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        FragmentManager manager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            mHomeFragment = (HomeFragment) manager.getFragment(savedInstanceState, HomeFragment.TAG);
            mProjectClassifyFragment = (ProjectClassifyFragment) manager.getFragment(savedInstanceState, ProjectClassifyFragment.TAG);
            mRecreationFragment = (RecreationFragment) manager.getFragment(savedInstanceState, RecreationFragment.TAG);
        } else {
            mHomeFragment = HomeFragment.newInstance();
            mProjectClassifyFragment = ProjectClassifyFragment.newInstance();
            mRecreationFragment = RecreationFragment.newInstance();
        }

        if (!mHomeFragment.isAdded()) {
            manager.beginTransaction()
                    .add(R.id.fl_container, mHomeFragment, HomeFragment.TAG)
                    .commit();
        }

        if (!mProjectClassifyFragment.isAdded()) {
            manager.beginTransaction()
                    .add(R.id.fl_container, mProjectClassifyFragment, ProjectClassifyFragment.TAG)
                    .commit();
        }

        if (!mRecreationFragment.isAdded()) {
            manager.beginTransaction()
                    .add(R.id.fl_container, mRecreationFragment, RecreationFragment.TAG)
                    .commit();
        }

        new ProjectClassifyPresenter(mProjectClassifyFragment,
                ProjectClassifyPepository.getInstance(new ProjectClassifyRemoteDataSource()));

        showHomeFragment();
    }

    public void showHomeFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .show(mHomeFragment)
                .hide(mProjectClassifyFragment)
                .hide(mRecreationFragment)
                .commit();

    }

    public void showProjectClassifyFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .show(mProjectClassifyFragment)
                .hide(mHomeFragment)
                .hide(mRecreationFragment)
                .commit();
    }

    public void showRecreationFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .show(mRecreationFragment)
                .hide(mHomeFragment)
                .hide(mProjectClassifyFragment)
                .commit();
    }

    @Override
    protected void initEvent() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.nav_my_collection:
                        // TODO: 2018/8/6 我的收藏
                        break;
                    case R.id.nav_later_read:
                        // TODO: 2018/8/6 稍后再看
                        break;
                    case R.id.nav_skin_mode:
                        // TODO: 2018/8/6 日/夜间模式
                        break;
                    case R.id.nav_setting:
                        // TODO: 2018/8/6 设置
                        break;
                    case R.id.nav_logout:
                        // TODO: 2018/8/6 注销
                        break;
                }
                return true;
            }
        });

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bnv_home:
                        // TODO: 2018/8/6 首页
                        showHomeFragment();
                        break;
                    case R.id.bnv_project:
                        // TODO: 2018/8/6 项目
                        showProjectClassifyFragment();
                        break;
                    case R.id.bnv_recreation:
                        // TODO: 2018/8/6 娱乐
                        showRecreationFragment();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FragmentManager manager = getSupportFragmentManager();
        if (mHomeFragment.isAdded()) {
            manager.putFragment(outState, HomeFragment.TAG, mHomeFragment);
        }
        if (mProjectClassifyFragment.isAdded()) {
            manager.putFragment(outState, ProjectClassifyFragment.TAG, mProjectClassifyFragment);
        }

        if (mRecreationFragment.isAdded()) {
            manager.putFragment(outState, RecreationFragment.TAG, mRecreationFragment);
        }
    }
}
