package com.heisenbrg.motionxmple.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class ScrollDisabledViewPager extends ViewPager {

    private boolean interceptTouchEvent = true;

    public ScrollDisabledViewPager(@NonNull Context context) {
        super(context);
    }

    public ScrollDisabledViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return this.interceptTouchEvent && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.interceptTouchEvent && super.onInterceptTouchEvent(ev);
    }

    public void setPagingDisabled() {
        this.interceptTouchEvent = false;
    }
}
