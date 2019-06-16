package com.kuanhsien.app.sample.android_mvvm_demo.data;

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
    List<ItemInfoModel> getItemInfoList();

    @Query("SELECT * FROM item_info_table WHERE item_id = :itemId")
    ItemInfoModel getItemInfo(String itemId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItemAll(ItemInfoModel... items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(ItemInfoModel item);

    @Delete
    void deleteItem(ItemInfoModel item);
}
