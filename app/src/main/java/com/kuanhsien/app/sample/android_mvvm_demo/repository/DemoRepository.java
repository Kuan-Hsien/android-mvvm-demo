package com.kuanhsien.app.sample.android_mvvm_demo.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.kuanhsien.app.sample.android_mvvm_demo.base.DemoConstants;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.AppDatabase;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.InfoDao;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.ItemInfoDao;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.ItemInfoModel;


public class DemoRepository {

    private InfoDao mInfoDao;
    private ItemInfoDao mItemInfoDao;

    public DemoRepository(Context context) {

        // use ApplicationContext to get database
        mInfoDao = AppDatabase.getInstance(context.getApplicationContext()).getInfoDao();
        mItemInfoDao = AppDatabase.getInstance(context.getApplicationContext()).getItemInfoDao();
    }

    public void insertInfoAll(InfoModel... info) {
        mInfoDao.insertInfoAll(info);
    }

    public void insertItemAll(ItemInfoModel... items) {
        mItemInfoDao.insertItemAll(items);
    }

    public void prepareData() {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                insertInfoAll(
                        new InfoModel(DemoConstants.AUTHOR, "A" , "Desc"),
                        new InfoModel(DemoConstants.COVER, "Cover-Title" , "Cover-Desc")
                );


                insertItemAll(
                        new ItemInfoModel("A", "A" , "Desc"),
                        new ItemInfoModel("B", "B" , "Desc"),
                        new ItemInfoModel("C", "C" , "Desc")
                );
            }
        });
    }

}
