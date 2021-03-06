package com.kuanhsien.app.sample.android_mvvm_demo.view;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kuanhsien.app.sample.android_mvvm_demo.R;
import com.kuanhsien.app.sample.android_mvvm_demo.base.BaseActivity;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.ItemInfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.base.Constants;
import com.kuanhsien.app.sample.android_mvvm_demo.viewmodel.ItemListViewModel;

import java.util.List;


public class ItemListActivity extends BaseActivity implements ItemListAdapter.OnItemClickListener {

    private ItemListViewModel mViewModel;
    private ItemListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        mViewModel = ViewModelProviders.of(this).get(ItemListViewModel.class);
        mViewModel.setRepository(this);

        setupView();
    }

    private void setupView() {

        hideToolbar();

        // 1. init recyclerview
        initRecyclerview();

        // 2. prepare viewModel and observe livedata
        mViewModel.dataList.observe(this, new Observer<List<ItemInfoModel>>() {
            @Override
            public void onChanged(List<ItemInfoModel> dataList) {

                // set view
                mAdapter.setData(dataList);
            }
        });

        // 3. use viewModel to get data from model
        mViewModel.prepareData();
    }

    private void initRecyclerview() {

        RecyclerView recyclerView = findViewById(R.id.recyclerview_item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ItemListAdapter();
        mAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(mAdapter);
    }


    // Implement ItemListAdapter.OnItemClickListener
    @Override
    public void onItemClick(ItemInfoModel data) {
        startDetailActivity(data.getId());
    }

    // Start item detail activity
    private void startDetailActivity(String itemId) {

        // set bundle
        Bundle bundle = new Bundle();
        bundle.putString(Constants.BUNDLE_KEY_ITEM_ID, itemId);

        // set intent
        Intent intent = new Intent(ItemListActivity.this, ItemDetailActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
