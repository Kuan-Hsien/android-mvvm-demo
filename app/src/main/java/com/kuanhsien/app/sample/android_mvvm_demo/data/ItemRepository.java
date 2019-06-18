package com.kuanhsien.app.sample.android_mvvm_demo.data;

import android.content.Context;
import java.util.List;
import androidx.lifecycle.LiveData;

public class ItemRepository {

    private ItemInfoDao mItemInfoDao;

    public ItemRepository(Context context) {

        // use ApplicationContext to get database
        mItemInfoDao = AppDatabase.getInstance(context.getApplicationContext()).getItemInfoDao();
    }

    // query and mutate data
    public LiveData<List<ItemInfoModel>> getItemInfoList() {
        return mItemInfoDao.getItemInfoList();
    }

    public LiveData<ItemInfoModel> getItemInfo(String itemId) {
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
}
