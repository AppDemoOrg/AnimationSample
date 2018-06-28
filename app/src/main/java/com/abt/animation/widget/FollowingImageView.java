package com.abt.animation.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.nineoldandroids.view.ViewHelper;

/**
 * @描述： @FollowingImageView
 * @作者： @黄卫旗
 * @创建时间： @28/06/2018
 */
public class FollowingImageView extends android.support.v7.widget.AppCompatImageView {

    private int mLastX;
    private int mLastY;

    public FollowingImageView(Context context) {
        super(context);
    }

    public FollowingImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FollowingImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                int translationX = (int) ViewHelper.getTranslationX(this) + deltaX;
                int translationY = (int) ViewHelper.getTranslationY(this) + deltaY;
                ViewHelper.setTranslationX(this, translationX);
                ViewHelper.setTranslationY(this, translationY);
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }
}
