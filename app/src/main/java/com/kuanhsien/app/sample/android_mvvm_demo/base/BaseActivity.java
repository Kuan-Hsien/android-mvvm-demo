package com.kuanhsien.app.sample.android_mvvm_demo.base;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public void hideToolbar() {

        // 設定隱藏標題
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        // 設定隱藏狀態
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}
