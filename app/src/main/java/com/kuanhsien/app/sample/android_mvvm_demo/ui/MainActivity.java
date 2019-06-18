package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import com.kuanhsien.app.sample.android_mvvm_demo.R;
import com.kuanhsien.app.sample.android_mvvm_demo.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ViewModel
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.setRepository(this);

        // DataBinding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mViewModel);   // set variables in xml
        binding.setLifecycleOwner(this);    // set lifecycle owner for Livedata in xml
    }

    @Override
    protected void onStart() {
        super.onStart();

        mViewModel.prepareData("Cover");
    }

    public void startItemListActivity(View view) {
        startActivity(new Intent(MainActivity.this, ItemListActivity.class));
    }

    public void startInfoActivity(View view) {
        startActivity(new Intent(MainActivity.this, InfoActivity.class));
    }
}
