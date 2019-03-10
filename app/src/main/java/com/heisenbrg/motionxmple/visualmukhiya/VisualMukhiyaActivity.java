package com.heisenbrg.motionxmple.visualmukhiya;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.heisenbrg.motionxmple.R;
import com.heisenbrg.motionxmple.widget.ScrollDisabledViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VisualMukhiyaActivity extends AppCompatActivity implements
        View.OnClickListener, VisualListener {

    @BindView(R.id.root_layout) MotionLayout rootLayout;
    @BindView(R.id.view_switcher) ViewSwitcher viewSwitcher;
    @BindView(R.id.tv) TextView textView;
    @BindView(R.id.view_pager) ScrollDisabledViewPager viewPager;

    private int transitionState = 0;

    private VisualFragment1 visualFragment1;
    private VisualFragment2 visualFragment2;
    private VisualFragment3 visualFragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual_mukhiya);
        ButterKnife.bind(this);

        viewPager.setPagingDisabled();

        Animation slideInRight = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        Animation slideOutLeft = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        viewSwitcher.setInAnimation(slideInRight);
        viewSwitcher.setOutAnimation(slideOutLeft);

        textView.setOnClickListener(this);

        FragmentManager manager = getSupportFragmentManager();
        visualFragment1 = VisualFragment1.newInstance();
        visualFragment2 = VisualFragment2.newInstance();
        visualFragment3 = VisualFragment3.newInstance();

        FragmentAdapter adapter = new FragmentAdapter(manager);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {

        rootLayout.setTransition(R.id.first_view_state, R.id.second_view_state);
        rootLayout.transitionToEnd();

//        if (transitionState != 3) {
//            if (transitionState == 0) {
//                rootLayout.setTransition(R.id.continue_state, R.id.next_state);
//                rootLayout.transitionToEnd();
//
//                viewSwitcher.showNext();
//
//                transitionState = 1;
//            } else if (transitionState == 1) {
//
//                viewPager.setCurrentItem(1, false);
//
//                transitionState = 2;
//            } else if (transitionState == 2) {
//                rootLayout.setTransition(R.id.next_state, R.id.create_account_state);
//                rootLayout.transitionToEnd();
//
//                viewPager.setCurrentItem(2, false);
//                new Handler().postDelayed(() -> {
//                    textView.setText("CREATE ACCOUNT");
//                }, 200);
//
//                transitionState = 3;
//            }
//        } else {
//            Toast.makeText(this, "Hurray!", Toast.LENGTH_SHORT).show();
//        }
    }

    @OnClick(R.id.tv_designer)
    void onClickDesignerName() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dribbble.com/Rahulbhadauria"));
        startActivity(browserIntent);
    }

    @Override
    public void onClickBack(View view, int position) {
        if (position == 1) {
            viewPager.setCurrentItem(0, false);
        } else if (position == 2){
            viewPager.setCurrentItem(1, false);

            rootLayout.setTransition(R.id.create_account_state, R.id.next_state);
            rootLayout.transitionToEnd();

            transitionState = 1;
        }
    }

    class FragmentAdapter extends FragmentPagerAdapter {
        FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return visualFragment1;
                case 1:
                    return visualFragment2;
                case 2:
                    return visualFragment3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
