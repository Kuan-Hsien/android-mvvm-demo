package com.kuanhsien.app.sample.android_mvvm_demo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.kuanhsien.app.sample.android_mvvm_demo.BaseTest;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.repository.InfoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;

public class MainViewModelTest extends BaseTest {

    // Mock Object
    @Mock
    InfoRepository mockRepository;
    @Mock
    Observer<InfoModel> mockInfoLiveData;

    // InjectMock: Inject Mock Objects into ViewModel
    @InjectMocks
    MainViewModel viewModel = new MainViewModel();


    // prepare testing data
    private String testId = "test";
    private InfoModel expectData = new InfoModel();
    private MutableLiveData<InfoModel> expectLiveData = new MutableLiveData<>();


    @Before
    @Override public void setUp() {
        super.setUp();

        // init
        expectLiveData.setValue(expectData);
        Mockito.when(mockRepository.getInfoLiveData(testId)).thenReturn(expectLiveData);
        viewModel.info.observeForever(mockInfoLiveData);
    }


    @Test
    public void verifyPrepareData() {
        viewModel.prepareData(testId);

        // verify
        Mockito.verify(mockRepository, times(1)).getInfoLiveData(testId);
        Mockito.verify(mockInfoLiveData, times(1)).onChanged(expectData);   // verify if onChange call exactly once and the arguments are matching
    }

}
