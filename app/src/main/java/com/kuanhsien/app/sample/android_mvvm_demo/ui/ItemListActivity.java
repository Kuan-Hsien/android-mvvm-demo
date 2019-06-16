package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kuanhsien.app.sample.android_mvvm_demo.R;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemInfoModel;
import java.util.List;


public class ItemListActivity extends AppCompatActivity {

    private ItemListViewModel mViewModel;
    private ItemListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        mViewModel = ViewModelProviders.of(this).get(ItemListViewModel.class);

        setupView();
    }

    private void setupView() {

        // 1. init recyclerview
        initRecyclerview();

        // 2. prepare viewModel and observe livedata
        mViewModel.getItemList().observe(this, new Observer<List<ItemInfoModel>>() {
            @Override
            public void onChanged(List<ItemInfoModel> itemInfo) {

                // set view
                // TODO: set view

            }
        });
        mViewModel.setRepository(this);

        // 3. use viewModel to get data from model
        mViewModel.prepareData();
    }

    private void initRecyclerview() {

        RecyclerView recyclerView = findViewById(R.id.recyclerview_item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ItemListAdapter();
        recyclerView.setAdapter(mAdapter);
    }
}
