package com.kuanhsien.app.sample.android_mvvm_demo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.kuanhsien.app.sample.android_mvvm_demo.BaseTest;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.ItemInfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.repository.ItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;


public class ItemDetailViewModelTest extends BaseTest {

    // Mock Object
    @Mock
    ItemRepository mockRepository;
    @Mock
    Observer<ItemInfoModel> mockItemInfoLiveData;

    // InjectMock: Inject Mock Objects into ViewModel
    @InjectMocks
    ItemDetailViewModel viewModel = new ItemDetailViewModel();


    // prepare testing data
    private String testId = "test";
    private ItemInfoModel expectData = new ItemInfoModel();
    private MutableLiveData<ItemInfoModel> expectLiveData = new MutableLiveData<>();


    @Before
    @Override public void setUp() {
        super.setUp();

        // init
        expectLiveData.setValue(expectData);
        Mockito.when(mockRepository.getItemInfoLiveData(testId)).thenReturn(expectLiveData);
        viewModel.itemInfo.observeForever(mockItemInfoLiveData);
    }


    @Test
    public void verifyPrepareData() {
        viewModel.prepareData(testId);

        // verify
        Mockito.verify(mockRepository, times(1)).getItemInfoLiveData(testId);
        Mockito.verify(mockItemInfoLiveData, times(1)).onChanged(expectData);
    }

}
