package com.heisenbrg.motionxmple.alpha;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.heisenbrg.motionxmple.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlphaFragment extends Fragment {

    public AlphaFragment() {}

    public static AlphaFragment newInstance(int position) {
        AlphaFragment fragment = new AlphaFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    private int position;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alpha, container, false);
        Context context = getContext();

        if (getArguments() != null) {
            position = getArguments().getInt("pos");
        }

        ImageView ivMain = view.findViewById(R.id.iv_main);

        if (position == 0) {
            ivMain.setImageDrawable(context.getDrawable(R.drawable.svg_onboarding_screen_01));
        } else if (position == 1) {
            ivMain.setImageDrawable(context.getDrawable(R.drawable.svg_onboarding_screen_02));
        } else if (position == 2) {
            ivMain.setImageDrawable(context.getDrawable(R.drawable.svg_onboarding_screen_03));
        }

        TextView tvTitle, tvDescription;

        tvTitle = view.findViewById(R.id.tv_title);
        tvDescription = view.findViewById(R.id.tv_description);

        String[] title = new String[]{"Engaging Video Lessons", "Unlimited Tests & Analysis", "Personalised Learning"};
        String[] description = new String[]{"Simple and effective videos covering all concepts",
                "Customized practice tests with in-depth analysis", "Unique learning journeys for every student"};

        if (position == 0) {
            tvTitle.setText(title[0]);
            tvDescription.setText(description[0]);
        } else if (position == 1) {
            tvTitle.setText(title[1]);
            tvDescription.setText(description[1]);
        } else if (position == 2) {
            tvTitle.setText(title[2]);
            tvDescription.setText(description[2]);
        }

        return view;
    }

}
