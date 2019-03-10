package com.heisenbrg.motionxmple.beta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heisenbrg.motionxmple.R;
import com.ifttt.sparklemotion.Decor;
import com.ifttt.sparklemotion.Page;
import com.ifttt.sparklemotion.SparkleMotion;
import com.ifttt.sparklemotion.SparkleViewPagerLayout;
import com.ifttt.sparklemotion.animations.ScaleAnimation;
import com.ifttt.sparklemotion.animations.TranslationAnimation;

import java.util.concurrent.atomic.AtomicBoolean;

public class BetaActivity extends AppCompatActivity {

    private BetaFirstFragment betaFirstFragment;
    private BetaSecondFragment betaSecondFragment;
    private BetaThirdFragment betaThirdFragment;

    private SparkleViewPagerLayout sparkleViewPagerLayout;

    private AtomicBoolean isFirstFragment = new AtomicBoolean();
    private AtomicBoolean isSecondFragment = new AtomicBoolean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beta);

        getWindow().setFlags(1024, 1024);

        betaFirstFragment = BetaFirstFragment.newInstance();
        betaSecondFragment = BetaSecondFragment.newInstance();
        betaThirdFragment = BetaThirdFragment.newInstance();

        FragmentManager manager = getSupportFragmentManager();

        sparkleViewPagerLayout = findViewById(R.id.sparkle_view_pager);

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setCornerRadius(8.0f);

        ViewPager viewPager = sparkleViewPagerLayout.getViewPager();

        SparkleMotion sparkleMotion = SparkleMotion.with(sparkleViewPagerLayout);

        viewPager.setAdapter(new AppAdapter(manager));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == 0 && ((double) positionOffset) > 0.11d && !isFirstFragment.getAndSet(true)) {
                    if (betaSecondFragment != null) {
                        betaSecondFragment.hideLogoViews();
                    }
                } else if (position == 1) {
                    isFirstFragment.set(false);
                    if (betaSecondFragment != null) {
                        betaSecondFragment.showLogoViews();
                    }
                }

                if (position == 1 && ((double) positionOffset) > 0.0d && !isSecondFragment.getAndSet(true)) {
                    if (betaSecondFragment != null) {
                        betaSecondFragment.hideMerchantViews();
                    }
                } else if (position == 1 && positionOffset == 0.0f) {
                    isSecondFragment.set(false);
                    if (betaSecondFragment != null) {
                        betaSecondFragment.showMerchantViews();
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //performing translation, scaling animations with help of SparkleViewPager
        performLogoMotion(sparkleViewPagerLayout, sparkleMotion);
        performMerchantLogoMotion(sparkleViewPagerLayout, sparkleMotion);
    }

    void performMerchantLogoMotion(SparkleViewPagerLayout viewPagerLayout, SparkleMotion sparkleMotion) {
        Decor decor = new Decor.Builder(LayoutInflater.from(viewPagerLayout.getContext()).inflate(R.layout.item_merchant_logo1, viewPagerLayout, false)).setPage(Page.singlePage(1)).build();

        ScaleAnimation scaleAnimation = new ScaleAnimation(Page.singlePage(1), 1.0f, 1.0f, 1.4f, 1.4f);

        TranslationAnimation translationAnimation = new TranslationAnimation(Page.singlePage(1), 0.0f, 0.0f, 250, 394, true);
        sparkleMotion.animate(scaleAnimation, translationAnimation).on(decor);

        decor = new Decor.Builder(LayoutInflater.from(viewPagerLayout.getContext()).inflate(R.layout.item_merchant_logo2, viewPagerLayout, false)).setPage(Page.singlePage(1)).build();
        translationAnimation = new TranslationAnimation(Page.singlePage(1), 0.0f, 0.0f, -244, 344, true);
        sparkleMotion.animate(scaleAnimation, translationAnimation).on(decor);

        decor = new Decor.Builder(LayoutInflater.from(viewPagerLayout.getContext()).inflate(R.layout.item_merchant_logo3, viewPagerLayout, false)).setPage(Page.singlePage(1)).build();
        translationAnimation = new TranslationAnimation(Page.singlePage(1), 0.0f, 0.0f, 248, -154, true);
        sparkleMotion.animate(scaleAnimation, translationAnimation).on(decor);
    }

    void performLogoMotion(SparkleViewPagerLayout viewPagerLayout, SparkleMotion sparkleMotion) {
        ViewGroup viewGroup = sparkleViewPagerLayout;

        View inflate1 = LayoutInflater.from(viewPagerLayout.getContext()).inflate(R.layout.item_simpl_logo, viewGroup, false);
        View inflate2 = LayoutInflater.from(viewPagerLayout.getContext()).inflate(R.layout.item_simpl_logo, viewGroup, false);
        View inflate3 = LayoutInflater.from(viewPagerLayout.getContext()).inflate(R.layout.item_simpl_logo, viewGroup, false);
        View inflate4 = LayoutInflater.from(viewPagerLayout.getContext()).inflate(R.layout.item_simpl_logo, viewGroup, false);

        ScaleAnimation scaleAnimation = new ScaleAnimation(Page.singlePage(0), 1.0f, 1.0f, 0.57f, 0.57f);

        Decor decor = new Decor.Builder(inflate1).setPage(Page.singlePage(0)).build();

        TranslationAnimation translationAnimation = new TranslationAnimation(Page.singlePage(0), 0.0f, 0.0f, getResources().getDimension(R.dimen.simpl_logo_margin_left), getResources().getDimension(R.dimen.simpl_logo_left_up), true);
        sparkleMotion.animate(scaleAnimation, translationAnimation).on(decor);

        decor = new Decor.Builder(inflate2).setPage(Page.singlePage(0)).build();
        sparkleMotion.animate(new TranslationAnimation(Page.singlePage(0), 0.0f, 0.0f, getResources().getDimension(R.dimen.simpl_logo_margin_left), getResources().getDimension(R.dimen.simpl_logo_third_left_down), true), scaleAnimation).on(decor);

        decor = new Decor.Builder(inflate3).setPage(Page.singlePage(0)).build();
        sparkleMotion.animate(new TranslationAnimation(Page.singlePage(0), 0.0f, 0.0f, getResources().getDimension(R.dimen.simpl_logo_right_width), getResources().getDimension(R.dimen.simpl_logo_third_right_up), true), scaleAnimation).on(decor);

        decor = new Decor.Builder(inflate4).setPage(Page.singlePage(0)).build();
        sparkleMotion.animate(new TranslationAnimation(Page.singlePage(0), 0.0f, 0.0f, getResources().getDimension(R.dimen.simpl_logo_right_width), getResources().getDimension(R.dimen.simpl_logo_third_right_down), true), scaleAnimation).on(decor);
    }

    class AppAdapter extends FragmentPagerAdapter {
        AppAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return betaFirstFragment;
            } else if (position == 1) {
                return betaSecondFragment;
            } else if (position == 2) {
                return betaThirdFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
