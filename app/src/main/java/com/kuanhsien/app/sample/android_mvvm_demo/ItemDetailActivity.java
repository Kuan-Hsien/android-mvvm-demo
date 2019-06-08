package com.kuanhsien.app.sample.android_mvvm_demo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.kuanhsien.app.sample.android_mvvm_demo.utils.Constants;


public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        setupView();
    }

    private void setupView() {

        // get value from bundle
        String itemId;
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            itemId = bundle.getString(Constants.BundleKeyItemId);
        } else {
            itemId = "";
        }

        TextView tvTitle = findViewById(R.id.tv_item_detail_title);
        tvTitle.setText(itemId);
    }
}
