package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.kuanhsien.app.sample.android_mvvm_demo.R;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoModel;


public class InfoActivity extends AppCompatActivity {

    private InfoViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        mViewModel = ViewModelProviders.of(this).get(InfoViewModel.class);

        setupView();
    }

    private void setupView() {

        // 1. get view component
        final TextView tvTitle = findViewById(R.id.tv_info_title);
        final TextView tvDesc = findViewById(R.id.tv_info_desc);
        final ImageView ivImage = findViewById(R.id.iv_info_image);


        // 2. prepare viewModel and observe livedata
        // (create livedata first, or will encounter NullPointerException)
        mViewModel.getInfo().observe(this, new Observer<InfoModel>() {
            @Override
            public void onChanged(InfoModel data) {

                // set view
                tvTitle.setText(data.getTitle());
                tvDesc.setText(data.getDesc());
                // ivImage.setBackgroundResource(data.getImageRes());
            }
        });
        mViewModel.setRepository(this);

        // 3. use viewModel to get data from model
        mViewModel.prepareData("Author");
    }
}
