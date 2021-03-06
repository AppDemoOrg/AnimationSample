package com.abt.animation.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.abt.animation.R;

public class FrameAnimationActivity extends AppCompatActivity {

    private ImageView mFrame1;
    private ImageView mFrame2;
    private ImageView mFrame3;
    private ImageView mFrame4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        mFrame1 = findViewById(R.id.activity_frame_frame1);
        mFrame2 = findViewById(R.id.activity_frame_frame2);
        mFrame3 = findViewById(R.id.activity_frame_frame3);
        mFrame4 = findViewById(R.id.activity_frame_frame4);
        startFrameAnimate();
    }

    private void startFrameAnimate() {
        mFrame1.setImageResource(R.drawable.frame_on_the_way);
        AnimationDrawable onTheWay = (AnimationDrawable) mFrame1.getDrawable();
        onTheWay.start();
        mFrame2.setImageResource(R.drawable.frame_page_loading);
        AnimationDrawable pageLoading = (AnimationDrawable) mFrame2.getDrawable();
        pageLoading.start();
        mFrame3.setImageResource(R.drawable.frame_alipay_success);
        AnimationDrawable alipaySuccess = (AnimationDrawable) mFrame3.getDrawable();
        alipaySuccess.start();
        mFrame4.setImageResource(R.drawable.frame_loading);
        AnimationDrawable loading = (AnimationDrawable) mFrame4.getDrawable();
        loading.start();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.zoomout); // activity退出时，过渡动画
    }

}
