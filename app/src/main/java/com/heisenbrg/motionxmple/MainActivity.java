package com.heisenbrg.motionxmple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.heisenbrg.motionxmple.alpha.AlphaActivity;
import com.heisenbrg.motionxmple.beta.BetaActivity;
import com.heisenbrg.motionxmple.tubik.TubikActivity;
import com.heisenbrg.motionxmple.visualmukhiya.VisualMukhiyaActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cv_1) CardView cv1;
    @BindView(R.id.tv_1) TextView tv1;

    @BindView(R.id.cv_2) CardView cv2;
    @BindView(R.id.tv_2) TextView tv2;

    @BindView(R.id.cv_3) CardView cv3;
    @BindView(R.id.tv_3) TextView tv3;

    @BindView(R.id.cv_4) CardView cv4;
    @BindView(R.id.tv_4) TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        GradientDrawable gd1 = new GradientDrawable();
        gd1.setColors(new int[]{0xFFFBC2EB, 0xFFA6C1EE});
        tv1.setBackground(gd1);
        cv1.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AlphaActivity.class));
        });

        GradientDrawable gd2 = new GradientDrawable();
        gd2.setColors(new int[]{0xFFFA709A, 0xFFFEE140});
        tv2.setBackground(gd2);
        cv2.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, BetaActivity.class));
        });

        GradientDrawable gd3 = new GradientDrawable();
        gd3.setColors(new int[]{0xFF30CFD0, 0xFF330867});
        tv3.setBackground(gd3);
        cv3.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, VisualMukhiyaActivity.class));
        });

        GradientDrawable gd4 = new GradientDrawable();
        gd4.setColors(new int[]{0xFFB3FFAB, 0xFF12FFF7});
        tv4.setBackground(gd4);
        cv4.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, TubikActivity.class));
        });
    }

    @OnClick(R.id.ib_test)
    void onClickIbTest() {
        Toast.makeText(this, "Clickked!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, TestActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
//        startActivity(new Intent(MainActivity.this, TestActivity.class));
    }
}
