package com.abt.animation.activity;

import android.support.v7.app.AppCompatActivity;

import com.abt.animation.R;
import com.abt.animation.util.StatusBarUtil;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
        initView();
    }

    /**
     * 初始化视图
     */
    public abstract void initView();

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0,R.anim.out_to_bottom);
    }

}
