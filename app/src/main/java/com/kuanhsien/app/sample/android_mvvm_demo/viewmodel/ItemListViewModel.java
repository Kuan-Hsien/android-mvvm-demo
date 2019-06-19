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
import java.util.List;


public class ItemListViewModel extends ViewModel {

    // Repository
    private ItemRepository mRepository;

    public void setRepository(Context context) {
        mRepository = new ItemRepository(context);
    }

    public void setRepository(ItemRepository repository) {
        mRepository = repository;
    }


    // LiveData
    private MutableLiveData<Boolean> mStartQuery = new MutableLiveData<>();
    public LiveData<List<ItemInfoModel>> dataList = Transformations.switchMap(mStartQuery, new Function<Boolean, LiveData<List<ItemInfoModel>>>() {
        @Override
        public LiveData<List<ItemInfoModel>> apply(Boolean input) {
            return mRepository.getItemInfoList();
        }
    });


    // fun
    public void prepareData() {

        mStartQuery.postValue(true);
    }
}
