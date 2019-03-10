package com.heisenbrg.motionxmple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.widget.Toast;

import com.heisenbrg.motionxmple.widget.AppGradientTextView;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.root_layout) ConstraintLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

//        GradientDrawable gd = new GradientDrawable();
//        gd.setColors(new int[]{0xFF74EBD5, 0xFF9FACE6});
//        rootLayout.setBackground(gd);

        AppGradientTextView tv = findViewById(R.id.gtv);
        tv.setGradientColor(0xFF74EBD5, 0xFF9FACE6);

        tv.setOnClickListener(view -> {
            Toast.makeText(this, "Yeahhhh!!!", Toast.LENGTH_SHORT).show();
        });
    }
}
