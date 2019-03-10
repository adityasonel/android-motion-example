package com.heisenbrg.motionxmple.beta;


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
public class BetaFirstFragment extends Fragment {

    public BetaFirstFragment() { }

    public static BetaFirstFragment newInstance(){
        return new BetaFirstFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_beta_first, container, false);
    }
}
