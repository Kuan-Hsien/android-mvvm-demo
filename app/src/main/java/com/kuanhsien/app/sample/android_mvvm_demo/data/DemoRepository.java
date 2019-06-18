package com.kuanhsien.app.sample.android_mvvm_demo.data;

import android.content.Context;
import android.os.AsyncTask;


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
