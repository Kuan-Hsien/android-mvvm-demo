package com.kuanhsien.app.sample.android_mvvm_demo.data.database;

import com.kuanhsien.app.sample.android_mvvm_demo.data.model.ItemInfoModel;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

/**
 * The Data Access Object for the [ItemInfoModel] class.
 */
@Dao
public interface ItemInfoDao {

    @Query("SELECT * FROM item_info_table")
    LiveData<List<ItemInfoModel>> getItemInfoListLiveData();

    @Query("SELECT * FROM item_info_table WHERE item_id = :itemId")
    LiveData<ItemInfoModel> getItemInfoLiveData(String itemId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItemAll(ItemInfoModel... items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(ItemInfoModel item);

    @Delete
    void deleteItem(ItemInfoModel item);
}
