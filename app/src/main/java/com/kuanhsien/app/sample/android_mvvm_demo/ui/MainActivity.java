package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.kuanhsien.app.sample.android_mvvm_demo.R;


public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        setupView();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mViewModel.prepareData();
    }

    // setup view in onCreate
    private void setupView() {

        // 1. get view component
        final Button btnA = findViewById(R.id.btn_a);
        final Button btnB = findViewById(R.id.btn_b);

        btnA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ItemListActivity.class));
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
            }
        });

        // 2. prepare viewModel
        mViewModel.setRepository(this);
    }
}
