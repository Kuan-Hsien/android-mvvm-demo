package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kuanhsien.app.sample.android_mvvm_demo.R;
import com.kuanhsien.app.sample.android_mvvm_demo.utils.Constants;


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
                startDetailActivity(btnA.getText().toString());
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startDetailActivity(btnB.getText().toString());
            }
        });

        mViewModel.setRepository(this);
    }


    // Start item detail
    private void startDetailActivity(String itemId) {

        // set bundle
        Bundle bundle = new Bundle();
        bundle.putString(Constants.BUNDLE_KEY_ITEM_ID, itemId);

        // set intent
        Intent intent = new Intent(MainActivity.this, ItemDetailActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
