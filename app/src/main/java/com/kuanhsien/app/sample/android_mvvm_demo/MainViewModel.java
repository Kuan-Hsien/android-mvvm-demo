package com.kuanhsien.app.sample.android_mvvm_demo;

import android.content.Context;

import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemInfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemRepository;

import androidx.lifecycle.ViewModel;

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
