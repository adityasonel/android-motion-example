package com.heisenbrg.motionxmple.visualmukhiya;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.heisenbrg.motionxmple.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisualFragment3 extends Fragment {


    public VisualFragment3() {}

    private VisualListener backListener;

    public static VisualFragment3 newInstance() {
        return new VisualFragment3();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visual_fragment3, container, false);
        TextView tvBack = view.findViewById(R.id.tv_back);
        tvBack.setOnClickListener(view1 -> {
            backListener.onClickBack(view1, 2);
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof VisualListener) {
            backListener = (VisualListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        backListener = null;
    }
}
