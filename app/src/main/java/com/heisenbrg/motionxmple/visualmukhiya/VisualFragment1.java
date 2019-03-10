package com.heisenbrg.motionxmple.visualmukhiya;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heisenbrg.motionxmple.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisualFragment1 extends Fragment {

    public VisualFragment1() {}

    public static VisualFragment1 newInstance() {
        return new VisualFragment1();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_visual_fragment1, container, false);
    }

}
