package com.kuanhsien.app.sample.android_mvvm_demo.viewmodel;

import android.content.Context;
import com.kuanhsien.app.sample.android_mvvm_demo.data.asynctask.GetInfoCallback;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.repository.InfoRepository;
import com.kuanhsien.app.sample.android_mvvm_demo.data.observable.ObservableInfoModel;


public class InfoViewModel implements GetInfoCallback {

    // Repository
    private InfoRepository mRepository;

    public void setRepository(Context context) {
        mRepository = new InfoRepository(context);
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
    public void prepareData(String itemId) {

        // [Get data from Model-Layer]
        mRepository.getInfo(this, itemId);
    }

    @Override
    public void onCompleted(InfoModel data) {
        mInfo.setValue(data);
    }
}
