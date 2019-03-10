package com.heisenbrg.motionxmple.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

import com.heisenbrg.motionxmple.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class ShadowCardView extends CardView {

    protected int a = -1;
    protected int b = -1;
    protected int c = -1;
    protected ColorStateList d = null;
    protected int e;
    protected int f;
    protected int g = -1;
    protected int h;
    protected int i;
    protected int j;

    public ShadowCardView(@NonNull Context context) {
        this(context, null, 0);
        init();
    }

    public ShadowCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public ShadowCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    private void init() {
        setContentPadding((getContentPaddingLeft() + this.j) - this.h,
                (getContentPaddingTop() + this.j) - this.i,
                (getContentPaddingRight() + this.j) + this.h,
                (getContentPaddingBottom() + this.i) + this.j);
    }
}
