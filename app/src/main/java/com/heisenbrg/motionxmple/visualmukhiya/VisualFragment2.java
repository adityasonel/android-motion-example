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
public class VisualFragment2 extends Fragment {

    private VisualListener backListener;

    public VisualFragment2() {}

    public static VisualFragment2 newInstance() {
        return new VisualFragment2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visual_fragment2, container, false);
        TextView tvBack = view.findViewById(R.id.tv_back);
        tvBack.setOnClickListener(view1 -> {
            backListener.onClickBack(view1, 1);
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
