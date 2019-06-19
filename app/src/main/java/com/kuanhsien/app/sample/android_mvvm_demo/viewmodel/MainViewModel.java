package com.kuanhsien.app.sample.android_mvvm_demo.viewmodel;

import android.content.Context;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.repository.InfoRepository;

public class MainViewModel extends ViewModel {

    // Repository
    private InfoRepository mInfoRepository;

    public void setRepository(Context context) {
        mInfoRepository = new InfoRepository(context);
    }

    public void setRepository(InfoRepository infoRepository) {
        mInfoRepository = infoRepository;
    }


    // LiveData
    private MutableLiveData<String> mId = new MutableLiveData<>();
    public LiveData<InfoModel> info = Transformations.switchMap(mId, new Function<String, LiveData<InfoModel>>() {
        @Override
        public LiveData<InfoModel> apply(String input) {
            return mInfoRepository.getInfo(input);
        }
    });

    public void prepareData(String id) {

        mId.postValue(id);
    }
}
