package com.kuanhsien.app.sample.android_mvvm_demo.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.ItemInfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.repository.ItemRepository;

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
    public LiveData<ItemInfoModel> getItemInfo() {
        if (mItemInfo == null) {
            mItemInfo = new MutableLiveData<>();
        }
        return mItemInfo;
    }

    // fun
    public void prepareData(final String itemId) {

        mRepository.getItemInfo(itemId).observeForever(new Observer<ItemInfoModel>() {
            @Override
            public void onChanged(ItemInfoModel data) {
                mItemInfo.postValue(data);
            }
        });

    }
}
