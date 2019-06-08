package com.kuanhsien.app.sample.android_mvvm_demo;

import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemInfoModel;

import androidx.lifecycle.ViewModel;

class ItemDetailViewModel extends ViewModel {

    private ItemInfoModel mItemInfo;

    ItemInfoModel getItemInfo() {
        return mItemInfo;
    }


    void prepareData(String itemId) {
        mItemInfo = new ItemInfoModel(itemId, "Title: " + itemId , "Desc", 0);
    }
}
