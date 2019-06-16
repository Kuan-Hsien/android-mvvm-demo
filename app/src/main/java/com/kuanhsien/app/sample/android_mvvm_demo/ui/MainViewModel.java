package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemRepository;

class MainViewModel extends ViewModel {

    // Repository
    private ItemRepository mRepository;

    void setRepository(Context context) {
        mRepository = new ItemRepository(context);
    }

    void setRepository(ItemRepository repository) {
        mRepository = repository;
    }

    // fun
    void prepareData() {
        mRepository.prepareTestItem();
    }
}
