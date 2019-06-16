package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.kuanhsien.app.sample.android_mvvm_demo.R;


public class InfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        setupView();
    }

    private void setupView() {

        // 1. get view component
        final TextView tvTitle = findViewById(R.id.tv_info_title);
        final TextView tvDesc = findViewById(R.id.tv_info_desc);
        final ImageView ivImage = findViewById(R.id.iv_info_image);
    }
}
