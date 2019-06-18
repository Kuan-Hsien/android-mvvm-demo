package com.kuanhsien.app.sample.android_mvvm_demo.ui;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoRepository;
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
    ObservableInfoModel getInfo() {
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
