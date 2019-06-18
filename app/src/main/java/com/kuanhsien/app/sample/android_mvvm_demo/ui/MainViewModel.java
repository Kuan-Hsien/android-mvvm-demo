package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoRepository;
import com.kuanhsien.app.sample.android_mvvm_demo.data.ItemRepository;

public class MainViewModel extends ViewModel {

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


    // LiveData
    private MutableLiveData<InfoModel> mInfo;

    LiveData<InfoModel> getInfo() {
        if (mInfo == null) {
            mInfo = new MutableLiveData<>();
        }
        return mInfo;
    }


    // fun
    void prepareTestData() {
        mItemRepository.prepareTestItem();
        mInfoRepository.prepareTestInfo();
    }

    void prepareData(final String itemId) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                mInfo.postValue(mInfoRepository.getInfo(itemId));
            }
        });
    }
}
