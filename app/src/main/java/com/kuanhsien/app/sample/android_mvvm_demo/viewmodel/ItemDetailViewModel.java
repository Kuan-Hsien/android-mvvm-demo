package com.kuanhsien.app.sample.android_mvvm_demo.viewmodel;

import android.content.Context;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
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
    private MutableLiveData<String> mItemId = new MutableLiveData<>();
    public LiveData<ItemInfoModel> itemInfo = Transformations.switchMap(mItemId, new Function<String, LiveData<ItemInfoModel>>() {
        @Override
        public LiveData<ItemInfoModel> apply(String input) {
            return mRepository.getItemInfo(input);
        }
    });

    // fun
    public void prepareData(String itemId) {

        mItemId.postValue(itemId);
    }
}
