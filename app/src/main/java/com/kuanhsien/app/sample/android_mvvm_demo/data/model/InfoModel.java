package com.kuanhsien.app.sample.android_mvvm_demo.data.model;

import com.kuanhsien.app.sample.android_mvvm_demo.R;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "info_table")    // table-name (case-sensitive)
public class InfoModel {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "item_id")
    private String mId;

    @NonNull
    @ColumnInfo(name = "item_name")
    private String mTitle;

    @NonNull
    @ColumnInfo(name = "item_desc")
    private String mDesc;

    @ColumnInfo(name = "item_image_id")
    private int mImageRes;


    // Getters and setters are ignored for brevity,
    // but they're required for Room to work.
    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDesc() {
        return mDesc;
    }

    public int getImageRes() {
        return mImageRes;
    }

    public void setId(String id) {
        mId = id;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public void setImageRes(int imageRes) {
        mImageRes = imageRes;
    }


    // Constructors
    @Ignore
    public InfoModel() {
        mId = "";
        mTitle = "";
        mDesc = "";
        mImageRes = R.drawable.img_placeholder;
    }

    @Ignore
    public InfoModel(@NonNull String id, @NonNull String title, @NonNull String desc) {
        mId = id;
        mTitle = title;
        mDesc = desc;
        mImageRes = R.drawable.img_placeholder;
    }

    public InfoModel(@NonNull String id, @NonNull String title, @NonNull String desc, int imageRes) {
        mId = id;
        mTitle = title;
        mDesc = desc;
        mImageRes = imageRes;
    }

}
