package com.heisenbrg.motionxmple.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;

import com.heisenbrg.motionxmple.R;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

public class AppGradientTextView extends AppCompatTextView {

    private int startColor, endColor, gradientType;
    private final static float FDEG2RAD = ((float) Math.PI / 180.f);

    private static final int DEFAULT_START_COLOUR = 0xffffb199;
    private static final int DEFAULT_END_COLOUR = 0xff9f51ff;

    public AppGradientTextView(Context context) {
        super(context);
    }

    public AppGradientTextView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.AppGradientTextView, 0, 0);

        this.startColor = obtainStyledAttributes.getColor(R.styleable.AppGradientTextView_startColor, DEFAULT_START_COLOUR);
        this.endColor = obtainStyledAttributes.getColor(R.styleable.AppGradientTextView_endColor, DEFAULT_END_COLOUR);
        this.gradientType = obtainStyledAttributes.getInt(R.styleable.AppGradientTextView_gradientType, 0);

        obtainStyledAttributes.recycle();
    }

    public AppGradientTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setGradientColor(int startColor, int endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
        init();
        invalidate();
    }

    private void init() {
        float f;
        float f2;
        float measureText = getPaint().measureText(getText().toString());
        if (gradientType == 0) {
            f = measureText;
            f2 = FDEG2RAD;
        } else {
            f2 = (float) getHeight();
            f = FDEG2RAD;
        }
        getPaint().setShader(new LinearGradient(FDEG2RAD, FDEG2RAD, f, f2, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            init();
        }
    }
}
