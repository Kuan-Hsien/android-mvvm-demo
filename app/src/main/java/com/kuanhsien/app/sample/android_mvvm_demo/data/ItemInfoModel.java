package com.kuanhsien.app.sample.android_mvvm_demo.data;

public class ItemInfoModel {

    private String mId;
    private String mTitle;
    private String mDesc;
    private int mImageRes;

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
    public ItemInfoModel(String id, String title, String desc, int imageRes) {
        mId = id;
        mTitle = title;
        mDesc = desc;
        mImageRes = imageRes;
    }

}
