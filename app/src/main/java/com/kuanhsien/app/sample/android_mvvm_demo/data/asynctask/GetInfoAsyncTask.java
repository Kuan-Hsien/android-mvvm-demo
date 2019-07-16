package com.kuanhsien.app.sample.android_mvvm_demo.data.asynctask;

import android.os.AsyncTask;
import com.kuanhsien.app.sample.android_mvvm_demo.data.database.InfoDao;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;


public class GetInfoAsyncTask extends AsyncTask<String, Void, InfoModel> {

    private InfoDao mAsyncDao;
    private GetInfoCallback mCallback;
    private String mItemId;

    public GetInfoAsyncTask(InfoDao dao, GetInfoCallback callback, String itemId) {
        mAsyncDao = dao;
        mCallback = callback;
        mItemId = itemId;
    }

    @Override
    protected InfoModel doInBackground(String... strings) {
        return mAsyncDao.getInfo(mItemId);
    }

    @Override
    protected void onPostExecute(InfoModel infoModel) {
        mCallback.onCompleted(infoModel);
    }
}
