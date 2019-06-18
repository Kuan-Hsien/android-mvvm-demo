package com.kuanhsien.app.sample.android_mvvm_demo.viewmodel;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.repository.InfoRepository;
import com.kuanhsien.app.sample.android_mvvm_demo.data.observable.ObservableInfoModel;


public class InfoViewModel {

    // Repository
    private InfoRepository mRepository;

    public void setRepository(Context context) {
        mRepository = new InfoRepository(context);
    }

    public void setRepository(InfoRepository repository) {
        mRepository = repository;
    }


    // [Notify View-Layer observers]
    // Self-implemented observer-pattern
    private ObservableInfoModel mInfo;
    public ObservableInfoModel getInfo() {
        if (mInfo == null) {
            mInfo = new ObservableInfoModel(new InfoModel());
        }
        return mInfo;
    }

    // fun
    public void prepareData(final String itemId) {

        // [Get data from Model-Layer]
        mRepository.getInfo(itemId).observeForever(new Observer<InfoModel>() {
            @Override
            public void onChanged(InfoModel data) {
                mInfo.setValue(data);
            }
        });
    }
}
