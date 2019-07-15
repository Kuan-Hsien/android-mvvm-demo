package com.kuanhsien.app.sample.android_mvvm_demo.data.asynctask;

import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;


public interface GetInfoCallback {

    void onCompleted(InfoModel data);

}
