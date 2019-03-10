package com.heisenbrg.motionxmple.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RoundedFrameLayout extends FrameLayout {

    public final static float FLOAT_EPSILON = Float.intBitsToFloat(1);

    private Bitmap bitmap;
    private Paint paint1;
    private Paint paint2;
    private float cornerRadius;

    public RoundedFrameLayout(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public RoundedFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public RoundedFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.cornerRadius = TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics());
        this.paint1 = new Paint(1);
        this.paint2 = new Paint(3);
        this.paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        setWillNotDraw(false);
    }

    private Bitmap bitmap(int width, int height) {
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ALPHA_8);

        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        float f = (float) width;
        float f2 = (float) height;

        RectF rectF = new RectF(FLOAT_EPSILON, FLOAT_EPSILON, f, f2);

        canvas.drawRect(FLOAT_EPSILON, FLOAT_EPSILON, f, f2, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));

        canvas.drawRoundRect(rectF, this.cornerRadius, this.cornerRadius, paint);
        return createBitmap;
    }

    public void draw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        super.draw(canvas2);
        if (this.bitmap == null) {
            this.bitmap = bitmap(getWidth(), getHeight());
        }
        canvas2.drawBitmap(this.bitmap, FLOAT_EPSILON, FLOAT_EPSILON, this.paint2);
        canvas.drawBitmap(createBitmap, FLOAT_EPSILON, FLOAT_EPSILON, this.paint1);
    }
}
