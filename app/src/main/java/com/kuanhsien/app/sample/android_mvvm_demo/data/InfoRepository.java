package com.kuanhsien.app.sample.android_mvvm_demo.data;

import android.content.Context;
import android.os.AsyncTask;
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


    public void prepareTestInfo() {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                insertInfoAll(
                        new InfoModel("Author", "A" , "Desc"),
                        new InfoModel("Cover", "Cover-Title" , "Cover-Desc")
                );
            }
        });
    }

}
