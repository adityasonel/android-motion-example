package com.heisenbrg.motionxmple.testing;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.heisenbrg.motionxmple.R;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.root_layout) RelativeLayout rootLayout;

    private ActionBar actionBar;
    private ColorDrawable colorDrawable;

    private int[] colors = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        colors[0] = 0xFFF0F0F0;
        colors[1] = 0xFFFFFFFF;
        colors[2] = 0xFFFFFFFF;

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        colorDrawable = new ColorDrawable(colors[0]);
        actionBar.setBackgroundDrawable(colorDrawable);
    }
}
