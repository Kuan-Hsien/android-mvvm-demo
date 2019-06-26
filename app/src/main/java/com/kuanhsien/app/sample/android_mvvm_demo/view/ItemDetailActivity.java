package com.kuanhsien.app.sample.android_mvvm_demo.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.kuanhsien.app.sample.android_mvvm_demo.R;
import com.kuanhsien.app.sample.android_mvvm_demo.base.BaseActivity;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.ItemInfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.base.Constants;
import com.kuanhsien.app.sample.android_mvvm_demo.viewmodel.ItemDetailViewModel;


public class ItemDetailActivity extends BaseActivity {

    private ItemDetailViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        mViewModel = ViewModelProviders.of(this).get(ItemDetailViewModel.class);
        mViewModel.setRepository(this);

        setupView();
    }

    private void setupView() {

        hideToolbar();

        // 1. get view component
        final TextView tvTitle = findViewById(R.id.tv_item_detail_title);
        final TextView tvDesc = findViewById(R.id.tv_item_detail_desc);
        final ImageView ivImage = findViewById(R.id.iv_item_detail_image);

        // 2. prepare viewModel and observe livedata
        // (create livedata first, or will encounter NullPointerException)
        mViewModel.itemInfo.observe(this, new Observer<ItemInfoModel>() {
            @Override
            public void onChanged(ItemInfoModel data) {

                // set view
                tvTitle.setText(data.getTitle());
                tvDesc.setText(data.getDesc());
                ivImage.setBackgroundResource(data.getImageRes());
            }
        });

        // 3. get data and setup view
        // get value from bundle
        String itemId;
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            itemId = bundle.getString(Constants.BUNDLE_KEY_ITEM_ID);
        } else {
            itemId = "";
        }

        // 4. use viewModel to get data from model
        mViewModel.prepareData(itemId);
    }
}
