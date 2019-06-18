package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.kuanhsien.app.sample.android_mvvm_demo.R;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoModel;


public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.setRepository(this);

        setupView();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mViewModel.prepareData("Cover");
    }

    // setup view in onCreate
    private void setupView() {

        // 1. get view component
        final TextView tvTitle = findViewById(R.id.tv_cover_title);
        final TextView tvDesc = findViewById(R.id.tv_cover_desc);
        final ImageView ivImage = findViewById(R.id.iv_cover_image);
        final Button btnToItemPage = findViewById(R.id.btn_to_item_page);
        final Button btnToInfoPage = findViewById(R.id.btn_to_info_page);

        btnToItemPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ItemListActivity.class));
            }
        });

        btnToInfoPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
            }
        });

        // 2. prepare viewModel and observe livedata
        mViewModel.getInfo().observe(this, new Observer<InfoModel>() {
            @Override
            public void onChanged(InfoModel data) {

                // set view
                tvTitle.setText(data.getTitle());
                tvDesc.setText(data.getDesc());
                ivImage.setBackgroundResource(data.getImageRes());
            }
        });

        mViewModel.prepareTestData();
    }
}
