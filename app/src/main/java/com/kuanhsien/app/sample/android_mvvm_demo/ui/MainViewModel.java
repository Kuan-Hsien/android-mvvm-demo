package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoRepository;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemRepository;

class MainViewModel extends ViewModel {

    // Repository
    private ItemRepository mItemRepository;
    private InfoRepository mInfoRepository;

    void setRepository(Context context) {
        mItemRepository = new ItemRepository(context);
        mInfoRepository = new InfoRepository(context);
    }

    void setRepository(ItemRepository itemRepository, InfoRepository infoRepository) {
        mItemRepository = itemRepository;
        mInfoRepository = infoRepository;
    }

    // fun
    void prepareData() {
        mItemRepository.prepareTestItem();
        mInfoRepository.prepareTestInfo();
    }
}
