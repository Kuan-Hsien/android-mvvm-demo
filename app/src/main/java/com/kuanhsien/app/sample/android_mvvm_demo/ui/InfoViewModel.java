package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoRepository;


public class InfoViewModel extends ViewModel {

    // Repository
    private InfoRepository mRepository;

    void setRepository(Context context) {
        mRepository = new InfoRepository(context);
    }

    void setRepository(InfoRepository repository) {
        mRepository = repository;
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
    void prepareData(final String itemId) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                mInfo.postValue(mRepository.getInfo(itemId));
            }
        });
    }
}
