package com.kuanhsien.app.sample.android_mvvm_demo.data.observable;

import com.kuanhsien.app.sample.android_mvvm_demo.data.InfoModel;

public class ObservableInfoModel extends ObservableData {

    private InfoModel mInfoModel;

    // Constructor
    public ObservableInfoModel(InfoModel infoModel) {
        mInfoModel = infoModel;
    }

    // Getter
    public InfoModel getValue() {
        return mInfoModel;
    }

    // Setter
    public void setValue(InfoModel infoModel) {
        mInfoModel = infoModel;
        notifyObservers();  // notify observers
    }
}
