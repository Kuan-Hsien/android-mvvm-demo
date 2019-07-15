package com.kuanhsien.app.sample.android_mvvm_demo.repository;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.kuanhsien.app.sample.android_mvvm_demo.data.asynctask.GetInfoAsyncTask;
import com.kuanhsien.app.sample.android_mvvm_demo.data.asynctask.GetInfoCallback;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.AppDatabase;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.InfoDao;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;
import java.util.List;


public class InfoRepository {

    private InfoDao mInfoDao;

    public InfoRepository(Context context) {

        // use ApplicationContext to get database
        mInfoDao = AppDatabase.getInstance(context.getApplicationContext()).getInfoDao();
    }

    // query and mutate data
    public LiveData<List<InfoModel>> getInfoListLiveData() {
        return mInfoDao.getInfoListLiveData();
    }

    public LiveData<InfoModel> getInfoLiveData(String infoId) {
        return mInfoDao.getInfoLiveData(infoId);
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


    // [Demo] query with asyncTask, and do not return LiveData
    public void getInfo(GetInfoCallback callback, String infoId) {
        new GetInfoAsyncTask(mInfoDao, callback, infoId).execute();
    }
}
