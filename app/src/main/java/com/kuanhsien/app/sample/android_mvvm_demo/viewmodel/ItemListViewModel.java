package com.kuanhsien.app.sample.android_mvvm_demo.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
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
    private MutableLiveData<List<ItemInfoModel>> mDataList;
    public LiveData<List<ItemInfoModel>> getDataList() {
        if (mDataList == null) {
            mDataList = new MutableLiveData<>();
        }
        return mDataList;
    }


    // fun
    public void prepareData() {

        mRepository.getItemInfoList().observeForever(new Observer<List<ItemInfoModel>>() {
            @Override
            public void onChanged(List<ItemInfoModel> dataList) {
                mDataList.postValue(dataList);
            }
        });
    }
}
