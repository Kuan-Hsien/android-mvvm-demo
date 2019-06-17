package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.kuanhsien.app.sample.android_mvvm_demo.R;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.observable.IObserver;


public class InfoActivity extends AppCompatActivity implements IObserver {

    private InfoViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        mViewModel = new InfoViewModel();

        setupView();
    }

    private void setupView() {

        // 1. prepare viewModel and observe observable
        mViewModel.getInfo().registerObserver(this);
        mViewModel.setRepository(this);

        // 2. use viewModel to get data from model
        mViewModel.prepareData("Author");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 3. remove register
        mViewModel.getInfo().removeObserver(this);
    }


    // Implement IObserver to update UI while observable updated
    @Override
    public void update() {

        // 1. get view component
        TextView tvTitle = findViewById(R.id.tv_info_title);
        TextView tvDesc = findViewById(R.id.tv_info_desc);
        ImageView ivImage = findViewById(R.id.iv_info_image);

        // 2. get Observable
        InfoModel data = mViewModel.getInfo().getValue();

        // 3. update view
        tvTitle.setText(data.getTitle());
        tvDesc.setText(data.getDesc());
        ivImage.setBackgroundResource(data.getImageRes());
    }
}
