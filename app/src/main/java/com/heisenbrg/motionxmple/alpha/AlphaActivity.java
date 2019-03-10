package com.heisenbrg.motionxmple.alpha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.heisenbrg.motionxmple.R;
import com.heisenbrg.motionxmple.widget.InkPageIndicator;
import com.heisenbrg.motionxmple.widget.ParallaxPageTransformer;

public class AlphaActivity extends AppCompatActivity {

    private Context context;
    private TextView tvSkip, tvNext;
    private GradientDrawable gradientDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha);
        context = getApplicationContext();

        tvSkip = findViewById(R.id.tv_skip);
        tvNext = findViewById(R.id.tv_next);

        ViewPager viewPager = findViewById(R.id.view_pager);
        Adapter adapter = new Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        ArgbEvaluator argbEvaluator = new ArgbEvaluator();

        final int orLight = ContextCompat.getColor(this, android.R.color.holo_orange_light);
        final int orDark = ContextCompat.getColor(this, android.R.color.holo_orange_dark);

        final int grLight = ContextCompat.getColor(this, android.R.color.holo_green_light);
        final int grDark = ContextCompat.getColor(this, android.R.color.holo_green_dark);

        final int blLight = ContextCompat.getColor(this, android.R.color.holo_blue_light);
        final int blDark = ContextCompat.getColor(this, android.R.color.holo_blue_dark);

        final int[] iArrLight = new int[]{orLight, grLight, blLight};
        final int[] iArrDark = new int[]{orDark, grDark, blDark};

        gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int valueOfLight = iArrLight[position];
                int valueOfDark = iArrDark[position];

                if (position != 2) {
                    position++;
                }

                int positionLight = (int) argbEvaluator.evaluate(positionOffset, valueOfLight, iArrLight[position]);
                int positionDark = (int) argbEvaluator.evaluate(positionOffset, valueOfDark, iArrDark[position]);

                gradientDrawable.setColors(new int[]{positionLight, positionDark});

                viewPager.setBackground(gradientDrawable);
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    tvSkip.setVisibility(View.VISIBLE);
                    tvNext.setText("Next");
                } else if (position == 2){
                    tvSkip.setVisibility(View.INVISIBLE);
                    tvNext.setText("Get Started");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setPageTransformer(true,
                new ParallaxPageTransformer()
                        .pageTransformer(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.iv_main, -1.8f, -1.8f))
                        .pageTransformer(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.tv_title, -0.4f, -0.4f))
                        .pageTransformer(new ParallaxPageTransformer.ParallaxTransformInformation(R.id.tv_description, -0.4f, -0.4f)));

        InkPageIndicator pageIndicator = findViewById(R.id.page_indicator);
        pageIndicator.setViewPager(viewPager);

        tvSkip.setOnClickListener(view -> {
            Toast.makeText(context, "Hurrray, you are awesome!", Toast.LENGTH_SHORT).show();
        });
        tvNext.setOnClickListener(view -> {
            if (viewPager.getCurrentItem() == 0) {
                viewPager.setCurrentItem(1);
            } else if (viewPager.getCurrentItem() == 1) {
                viewPager.setCurrentItem(2);
            } else {
                Toast.makeText(context, "Hurrray, you are awesome!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class Adapter extends FragmentPagerAdapter {
        Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return AlphaFragment.newInstance(position);
            } else if (position == 1) {
                return AlphaFragment.newInstance(position);
            } else if (position == 2) {
                return AlphaFragment.newInstance(position);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
