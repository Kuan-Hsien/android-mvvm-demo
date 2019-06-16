package com.kuanhsien.app.sample.android_mvvm_demo.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.kuanhsien.app.sample.android_mvvm_demo.utils.Constants;

@Database(entities = {
        ItemInfoModel.class,
        InfoModel.class
}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    // Dao
    public abstract ItemInfoDao getItemInfoDao();
    public abstract InfoDao getInfoDao();

    // Database instance (Singleton)
    private static AppDatabase mInstance;

    public static AppDatabase getInstance(Context context) {
        if (mInstance == null) {

            //synchronized block to remove overhead
            synchronized (AppDatabase.class) {

                // if instance is null, initialize
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(
                            context,
                            AppDatabase.class,
                            Constants.DATABASE_NAME
                    ).build();
                }
            }
        }
        return mInstance;
    }

    public static void onDestroy() {
        mInstance = null;
    }
}
