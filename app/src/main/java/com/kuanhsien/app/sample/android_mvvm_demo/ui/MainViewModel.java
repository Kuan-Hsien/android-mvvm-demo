package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Context;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoRepository;

public class MainViewModel extends ViewModel {

    // Repository
    private InfoRepository mInfoRepository;

    public void setRepository(Context context) {
        mInfoRepository = new InfoRepository(context);
    }

    public void setRepository(InfoRepository infoRepository) {
        mInfoRepository = infoRepository;
    }


    // LiveData
    private MutableLiveData<InfoModel> mInfo;

    public LiveData<InfoModel> getInfo() {
        if (mInfo == null) {
            mInfo = new MutableLiveData<>();
        }
        return mInfo;
    }


    public void prepareData(final String itemId) {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                mInfo.postValue(mInfoRepository.getInfo(itemId));
            }
        });
    }
}
