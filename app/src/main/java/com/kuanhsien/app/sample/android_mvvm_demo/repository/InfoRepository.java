package com.kuanhsien.app.sample.android_mvvm_demo.repository;

import android.content.Context;

import com.kuanhsien.app.sample.android_mvvm_demo.data.database.AppDatabase;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.InfoDao;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;

import java.util.List;
import androidx.lifecycle.LiveData;

public class InfoRepository {

    private InfoDao mInfoDao;

    public InfoRepository(Context context) {

        // use ApplicationContext to get database
        mInfoDao = AppDatabase.getInstance(context.getApplicationContext()).getInfoDao();
    }

    // query and mutate data
    public LiveData<List<InfoModel>> getInfoList() {
        return mInfoDao.getInfoList();
    }

    public LiveData<InfoModel> getInfo(String infoId) {
        return mInfoDao.getInfo(infoId);
    }

    public void insertInfoAll(InfoModel... info) {
        mInfoDao.insertInfoAll(info);
    }

    public void insertInfo(InfoModel info) {
        mInfoDao.insertInfo(info);
    }

    public void deleteInfo(InfoModel info) {
        mInfoDao.deleteInfo(info);
    }
}
