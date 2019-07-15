package com.kuanhsien.app.sample.android_mvvm_demo.repository;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.AppDatabase;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.ItemInfoDao;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.ItemInfoModel;
import java.util.List;


public class ItemRepository {

    private ItemInfoDao mItemInfoDao;

    public ItemRepository(Context context) {

        // use ApplicationContext to get database
        mItemInfoDao = AppDatabase.getInstance(context.getApplicationContext()).getItemInfoDao();
    }

    // query and mutate data
    public LiveData<List<ItemInfoModel>> getItemInfoListLiveData() {
        return mItemInfoDao.getItemInfoListLiveData();
    }

    public LiveData<ItemInfoModel> getItemInfoLiveData(String itemId) {
        return mItemInfoDao.getItemInfoLiveData(itemId);
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
