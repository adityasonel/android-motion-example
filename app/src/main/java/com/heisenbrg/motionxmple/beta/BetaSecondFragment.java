package com.heisenbrg.motionxmple.beta;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.heisenbrg.motionxmple.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BetaSecondFragment extends Fragment {

    public BetaSecondFragment() {}

    public static BetaSecondFragment newInstance(){
        return new BetaSecondFragment();
    }

    private ImageView iv1, iv2, iv3, iv4;
    private ImageView ivMerchant1, ivMerchant2, ivMerchant3;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beta_second, container, false);

        iv1 = view.findViewById(R.id.iv1);
        iv2 = view.findViewById(R.id.iv2);
        iv3 = view.findViewById(R.id.iv3);
        iv4 = view.findViewById(R.id.iv4);

        ivMerchant1 = view.findViewById(R.id.iv_merchant1);
        ivMerchant2 = view.findViewById(R.id.iv_merchant2);
        ivMerchant3 = view.findViewById(R.id.iv_merchant3);

        return view;
    }

    void showMerchantViews() {
        ivMerchant1.setVisibility(View.VISIBLE);
        ivMerchant2.setVisibility(View.VISIBLE);
        ivMerchant3.setVisibility(View.VISIBLE);
    }

    void hideMerchantViews() {
        ivMerchant1.setVisibility(View.INVISIBLE);
        ivMerchant2.setVisibility(View.INVISIBLE);
        ivMerchant3.setVisibility(View.INVISIBLE);
    }

    void showLogoViews() {
        iv1.setVisibility(View.VISIBLE);
        iv2.setVisibility(View.VISIBLE);
        iv3.setVisibility(View.VISIBLE);
        iv4.setVisibility(View.VISIBLE);
    }

    void hideLogoViews() {
        iv1.setVisibility(View.INVISIBLE);
        iv2.setVisibility(View.INVISIBLE);
        iv3.setVisibility(View.INVISIBLE);
        iv4.setVisibility(View.INVISIBLE);
    }
}
