package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemInfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemRepository;

public class ItemDetailViewModel extends ViewModel {

    // Repository
    private ItemRepository mRepository;

    public void setRepository(Context context) {
        mRepository = new ItemRepository(context);
    }

    public void setRepository(ItemRepository repository) {
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
    public void prepareData(final String itemId) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                mItemInfo.postValue(mRepository.getItemInfo(itemId));
            }
        });
    }
}
