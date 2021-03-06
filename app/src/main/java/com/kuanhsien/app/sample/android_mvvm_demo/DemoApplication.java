package com.kuanhsien.app.sample.android_mvvm_demo;

import android.app.Application;
import android.content.Context;
import com.kuanhsien.app.sample.android_mvvm_demo.repository.DemoRepository;
import com.kuanhsien.app.sample.android_mvvm_demo.base.Constants;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // [IS_FIRST_FLAG = true] means first login to this app
        if (getSharedPreferences(Constants.FILE_USER_DATA, Context.MODE_PRIVATE)
                .getBoolean(Constants.IS_FIRST_FLAG, true)) {
            firstLogin();
        }
    }

    public void firstLogin() {

        // (1) prepare default data
        prepareDatabase();

        // (2) show tips
        // TODO

        // (3) once login, save is_first_flag = false into shared-preferences
        getSharedPreferences(Constants.FILE_USER_DATA, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(Constants.IS_FIRST_FLAG, false)
                .apply();
    }

    private void prepareDatabase() {

        DemoRepository repository = new DemoRepository(this);
        repository.prepareData();
    }
}
