package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemInfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemRepository;

class ItemDetailViewModel extends ViewModel {

    // Repository
    private ItemRepository mRepository;

    void setRepository(Context context) {
        mRepository = new ItemRepository(context);
    }

    void setRepository(ItemRepository repository) {
        mRepository = repository;
    }


    // LiveData
    private MutableLiveData<ItemInfoModel> mItemInfo;

    LiveData<ItemInfoModel> getItemInfo() {
        if (mItemInfo == null) {
            mItemInfo = new MutableLiveData<>();
        }
        return mItemInfo;
    }


    // fun
    void prepareData(final String itemId) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                mItemInfo.postValue(mRepository.getItemInfo(itemId));
            }
        });
    }
}
