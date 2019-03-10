package com.heisenbrg.motionxmple.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewpager.widget.ViewPager;

public class AppMotionLayout extends MotionLayout implements ViewPager.OnPageChangeListener {
    public AppMotionLayout(Context context) {
        super(context);
    }

    public AppMotionLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppMotionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        setProgress((position+positionOffset));
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
