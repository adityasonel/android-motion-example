package com.heisenbrg.motionxmple.widget;

import android.view.View;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class ParallaxPageTransformer implements ViewPager.PageTransformer {

    private final static float FDEG2RAD = ((float) Math.PI / 180.f);

    private ArrayList<ParallaxTransformInformation> list = new ArrayList<>();

    public static class ParallaxTransformInformation {
        int view = -1;
        float transformLeft = 1.0f;
        float transformRight = 1.0f;

        public ParallaxTransformInformation(int id, float valueLeft, float valueRight) {
            this.view = id;
            this.transformLeft = valueLeft;
            this.transformRight = valueRight;
        }

        public boolean a() {
            return !(this.transformLeft == FDEG2RAD) && !(this.transformRight == FDEG2RAD) && view != -1;
        }

        boolean b() {
            return Math.abs(this.transformLeft - -101.1986f) < 1.0E-5f;
        }

        boolean c() {
            return Math.abs(this.transformRight - -101.1986f) < 1.0E-5f;
        }
    }

    public ParallaxPageTransformer pageTransformer(ParallaxTransformInformation parallaxTransformInformation) {
        if (list != null) {
            list.add(parallaxTransformInformation);
        }
        return this;
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        int width = page.getWidth();
        if (position < -1.0f) {
            page.setAlpha(1.0f);
        } else if (position > 1.0f || list == null) {
            page.setAlpha(1.0f);
        } else {
            for (ParallaxTransformInformation a : list) {
                setParallaxTransformInformation(page, position, width, a, position > FDEG2RAD);
            }
        }
    }

    private void setParallaxTransformInformation(View view, float position, int i, ParallaxTransformInformation parallaxTransformInformation, boolean z) {
        if (parallaxTransformInformation.a() && view.findViewById(parallaxTransformInformation.view) != null) {
            if (z && !parallaxTransformInformation.b()) {
                view.findViewById(parallaxTransformInformation.view).setTranslationX((-position) * (((float) i) / parallaxTransformInformation.transformLeft));
            } else if (!z && !parallaxTransformInformation.c()) {
                view.findViewById(parallaxTransformInformation.view).setTranslationX((-position) * (((float) i) / parallaxTransformInformation.transformRight));
            }
        }
    }
}
