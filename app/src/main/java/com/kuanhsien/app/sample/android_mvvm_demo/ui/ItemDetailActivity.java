package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.kuanhsien.app.sample.android_mvvm_demo.R;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemInfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.utils.Constants;


public class ItemDetailActivity extends AppCompatActivity {

    private ItemDetailViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        mViewModel = ViewModelProviders.of(this).get(ItemDetailViewModel.class);

        setupView();
    }

    private void setupView() {

        // 1. get view component
        final TextView tvTitle = findViewById(R.id.tv_item_detail_title);
        final TextView tvDesc = findViewById(R.id.tv_item_detail_desc);
        final ImageView ivImage = findViewById(R.id.iv_item_detail_image);

        // 2. prepare viewModel and observe livedata
        // (create livedata first, or will encounter NullPointerException)
        mViewModel.getItemInfo().observe(this, new Observer<ItemInfoModel>() {
            @Override
            public void onChanged(ItemInfoModel itemInfo) {

                // set view
                tvTitle.setText(itemInfo.getTitle());
                tvDesc.setText(itemInfo.getDesc());
                ivImage.setBackgroundResource(itemInfo.getImageRes());
            }
        });
        mViewModel.setRepository(this);

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
