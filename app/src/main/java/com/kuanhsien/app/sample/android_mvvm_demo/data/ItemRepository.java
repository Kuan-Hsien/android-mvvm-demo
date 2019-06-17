package com.kuanhsien.app.sample.android_mvvm_demo.data;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class ItemRepository {

    private ItemInfoDao mItemInfoDao;

    public ItemRepository(Context context) {

        // use ApplicationContext to get database
        mItemInfoDao = AppDatabase.getInstance(context.getApplicationContext()).getItemInfoDao();
    }

    // query and mutate data
    public List<ItemInfoModel> getItemInfoList() {
        return mItemInfoDao.getItemInfoList();
    }

    public ItemInfoModel getItemInfo(String itemId) {
        return mItemInfoDao.getItemInfo(itemId);
    }

    public void insertItemAll(ItemInfoModel... items) {
        mItemInfoDao.insertItemAll(items);
    }

    public void insertItem(ItemInfoModel item) {
        mItemInfoDao.insertItem(item);
    }

    public void deleteItem(ItemInfoModel item) {
        mItemInfoDao.deleteItem(item);
    }


    public void prepareTestItem() {
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                insertItemAll(
                        new ItemInfoModel("A", "A" , "Desc"),
                        new ItemInfoModel("B", "B" , "Desc"),
                        new ItemInfoModel("C", "C" , "Desc")
                );
            }
        });
    }

}
