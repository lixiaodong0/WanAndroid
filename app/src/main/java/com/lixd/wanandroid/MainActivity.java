package com.lixd.wanandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.lixd.wanandroid.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

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
    }

    @Override
    protected void initEvent() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.nav_my_collection:
                        break;
                    case R.id.nav_later_read:
                        break;
                    case R.id.nav_skin_mode:
                        break;
                    case R.id.nav_setting:
                        break;
                    case R.id.nav_logout:
                        break;
                }
                return true;
            }
        });
    }

}
