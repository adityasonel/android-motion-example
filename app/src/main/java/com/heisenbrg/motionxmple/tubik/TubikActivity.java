package com.heisenbrg.motionxmple.tubik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.heisenbrg.motionxmple.R;

public class TubikActivity extends AppCompatActivity {

    Context context;

    @BindView(R.id.root_layout) MotionLayout rootLayout;
    @BindView(R.id.ib_search) ImageButton ibSearch;
    @BindView(R.id.ib_more_vet) ImageButton ibMoreVert;

    @BindView(R.id.bottom_sheet) MotionLayout bottomSheet;

    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    // 0 = start, 1 = end
    int transitionState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tubik);
        ButterKnife.bind(this);
        context = getApplicationContext();

        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new AppAdapter());
    }

    @OnClick(R.id.bg_view)
    void onClickBgView() {
        if (transitionState == 1) {
            ibSearch.animate().alpha(1.0f).setDuration(320);
            ibMoreVert.animate().alpha(1.0f).setDuration(320);

            bottomSheet.transitionToStart();
            rootLayout.transitionToState(R.id.initial_bottombar_state);
            transitionState = 0;
        }
    }

    @OnClick(R.id.ib_arrow_up)
    void onClickArrowUp() {
        if (transitionState == 0) {
            ibSearch.animate().alpha(0.0f).setDuration(10);
            ibMoreVert.animate().alpha(0.0f).setDuration(10);

            bottomSheet.transitionToEnd();
            rootLayout.transitionToState(R.id.final_bottombar_state);
            transitionState = 1;
        } else if (transitionState == 1) {
            ibSearch.animate().alpha(1.0f).setDuration(320);
            ibMoreVert.animate().alpha(1.0f).setDuration(320);

            bottomSheet.transitionToStart();
            rootLayout.transitionToState(R.id.initial_bottombar_state);
            transitionState = 0;
        }
    }

    class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder> {

        AppAdapter() {}

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_material_design, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            if (position % 2 == 0) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(280, 420);
                params.gravity = Gravity.CENTER;
                params.setMargins(16, 0, 20, 0);
                holder.imageView.setLayoutParams(params);
            } else {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(280, 340);
                params.gravity = Gravity.CENTER;
                params.setMargins(16, 0, 20, 0);
                holder.imageView.setLayoutParams(params);
            }
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (transitionState == 1) {
            ibSearch.animate().alpha(1.0f).setDuration(320);
            ibMoreVert.animate().alpha(1.0f).setDuration(320);

            bottomSheet.transitionToStart();
            rootLayout.transitionToState(R.id.initial_bottombar_state);
            transitionState = 0;
        } else {
            super.onBackPressed();
        }
    }
}
