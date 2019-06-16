package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemInfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemRepository;
import java.util.List;


public class ItemListViewModel extends ViewModel {

    // Repository
    private ItemRepository mRepository;

    void setRepository(Context context) {
        mRepository = new ItemRepository(context);
    }

    void setRepository(ItemRepository repository) {
        mRepository = repository;
    }


    // LiveData
    private MutableLiveData<List<ItemInfoModel>> mDataList;

    LiveData<List<ItemInfoModel>> getItemList() {
        if (mDataList == null) {
            mDataList = new MutableLiveData<>();
        }
        return mDataList;
    }


    // fun
    void prepareData() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                mDataList.postValue(mRepository.getItemInfoList());
            }
        });
    }
}
