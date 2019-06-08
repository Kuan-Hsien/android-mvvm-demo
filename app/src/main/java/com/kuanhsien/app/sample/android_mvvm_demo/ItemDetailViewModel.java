package com.kuanhsien.app.sample.android_mvvm_demo;

import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemInfoModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

class ItemDetailViewModel extends ViewModel {

    private MutableLiveData<ItemInfoModel> mItemInfo;

    LiveData<ItemInfoModel> getItemInfo() {
        if (mItemInfo == null) {
            mItemInfo = new MutableLiveData<>();
        }
        return mItemInfo;
    }

    void prepareData(String itemId) {
        ItemInfoModel ItemInfo = new ItemInfoModel(itemId, "Title: " + itemId , "Desc", 0);
        mItemInfo.postValue(ItemInfo);
    }
}
