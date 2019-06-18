package com.kuanhsien.app.sample.android_mvvm_demo.data.database;

import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

/**
 * The Data Access Object for the [InfoModel] class.
 */
@Dao
public interface InfoDao {

    @Query("SELECT * FROM info_table")
    LiveData<List<InfoModel>> getInfoList();

    @Query("SELECT * FROM info_table WHERE item_id = :itemId")
    LiveData<InfoModel> getInfo(String itemId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertInfoAll(InfoModel... items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertInfo(InfoModel info);

    @Delete
    void deleteInfo(InfoModel info);
}