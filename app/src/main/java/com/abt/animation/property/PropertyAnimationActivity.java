package com.abt.animation.property;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.abt.animation.R;
import com.abt.animation.activity.BaseActivity;

/**
 * Created by rookie on 2016/8/8.
 */
public class PropertyAnimationActivity extends BaseActivity implements OnClickListener {

    private Context mContext;
    private ImageView mImgView;
    private int mScreenWidth;
    private ObjectAnimator mAnimObj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_property_animation);
    }

    @Override
    public void initView() {
        findViewById(R.id.alpha).setOnClickListener(this);
        findViewById(R.id.scale).setOnClickListener(this);
        findViewById(R.id.translate).setOnClickListener(this);
        findViewById(R.id.rotate).setOnClickListener(this);
        findViewById(R.id.set).setOnClickListener(this);
        mImgView = (ImageView) findViewById(R.id.myView);
        mImgView.setOnClickListener(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mScreenWidth = displayMetrics.widthPixels;
    }

    @Override
    public void onClick(View v) {
        if (mAnimObj != null && mImgView != null) {
            mAnimObj.end();
            mAnimObj.cancel();
            mImgView.clearAnimation();
            mAnimObj = null;
        }
        switch (v.getId()) {
            case R.id.set:
                ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(mImgView, "alpha", 1.0f, 0.5f, 0.8f, 1.0f);
                ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(mImgView, "scaleX", 0.0f, 1.0f);
                ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(mImgView, "scaleY", 0.0f, 2.0f);
                ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(mImgView, "rotation", 0, 360);
                ObjectAnimator transXAnim = ObjectAnimator.ofFloat(mImgView, "translationX", 100, 400);
                ObjectAnimator transYAnim = ObjectAnimator.ofFloat(mImgView, "translationY", 100, 750);
                AnimatorSet set = new AnimatorSet();
                set.playTogether(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
                // set.playSequentially(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
                set.setDuration(3000);
                set.start();
                break;
            case R.id.alpha:
                AlphaAnimation();
                break;
            case R.id.translate:
                TranslationAnimation();
                break;
            case R.id.scale:
                ScaleAnimation();
                break;
            case R.id.rotate:
                RotateAnimation();
                break;
            case R.id.myView:
                Toast.makeText(mContext, "我被点击了", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void ScaleAnimation() {
        mAnimObj = ObjectAnimator.ofFloat(mImgView, "scaleX", 0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f);
        mAnimObj.setDuration(1000);
        mAnimObj.setRepeatCount(-1);
        mAnimObj.start();

        mAnimObj.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.e("onAnimationStart", "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e("onAnimationEnd", "onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.e("onAnimationCancel", "onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.e("onAnimationRepeat", "onAnimationRepeat");
            }
        });
    }

    private void TranslationAnimation() {
        mAnimObj = ObjectAnimator.ofFloat(mImgView, "translationX", -200, 0, mScreenWidth, 0);
        mAnimObj.setInterpolator(new LinearInterpolator());
        mAnimObj.setRepeatCount(-1);
        mAnimObj.setDuration(2000);
        mAnimObj.start();
    }

    private void RotateAnimation() {
        mAnimObj = ObjectAnimator.ofFloat(mImgView, "rotation", 0f, 360f);
        mAnimObj.setDuration(1000);
        mAnimObj.start();
    }

    private void AlphaAnimation() {
        mAnimObj = ObjectAnimator.ofFloat(mImgView, "alpha", 1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f);
        mAnimObj.setRepeatCount(-1);
        mAnimObj.setRepeatMode(ObjectAnimator.REVERSE);
        mAnimObj.setDuration(2000);
        mAnimObj.start();
    }

}
