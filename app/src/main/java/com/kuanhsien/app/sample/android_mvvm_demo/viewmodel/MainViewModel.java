package com.kuanhsien.app.sample.android_mvvm_demo.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.repository.InfoRepository;

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

        mInfoRepository.getInfo(itemId).observeForever(new Observer<InfoModel>() {
            @Override
            public void onChanged(InfoModel data) {
                mInfo.postValue(data);
            }
        });
    }
}
