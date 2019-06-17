package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoRepository;
import com.kuanhsien.app.sample.android_mvvm_demo.data.observable.ObservableInfoModel;


public class InfoViewModel {

    // Repository
    private InfoRepository mRepository;

    void setRepository(Context context) {
        mRepository = new InfoRepository(context);
    }

    void setRepository(InfoRepository repository) {
        mRepository = repository;
    }


    // Self-implemented observer-pattern
    private ObservableInfoModel mInfo;
    ObservableInfoModel getInfo() {
        if (mInfo == null) {
            mInfo = new ObservableInfoModel(new InfoModel());
        }
        return mInfo;
    }

    // fun
    void prepareData(final String itemId) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                mInfo.setValue(mRepository.getInfo(itemId));
            }
        });
    }
}
