package com.kuanhsien.app.sample.android_mvvm_demo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.kuanhsien.app.sample.android_mvvm_demo.BaseTest;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.ItemInfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.repository.ItemRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;


public class ItemListViewModelTest extends BaseTest {

    // Mock Object
    @Mock
    ItemRepository mockRepository;
    @Mock
    Observer<List<ItemInfoModel>> mockDataListLiveData;

    // InjectMock: Inject Mock Objects into ViewModel
    @InjectMocks
    ItemListViewModel viewModel = new ItemListViewModel();


    // prepare testing data
    private List<ItemInfoModel> expectData = new ArrayList<>();
    private MutableLiveData<List<ItemInfoModel>> expectLiveData = new MutableLiveData<>();


    @Before
    @Override public void setUp() {
        super.setUp();

        // init
        expectLiveData.setValue(expectData);
        Mockito.when(mockRepository.getItemInfoListLiveData()).thenReturn(expectLiveData);
        viewModel.dataList.observeForever(mockDataListLiveData);
    }


    @Test
    public void verifyPrepareData() {
        viewModel.prepareData();

        // verify
        Mockito.verify(mockRepository, times(1)).getItemInfoListLiveData();
        Mockito.verify(mockDataListLiveData, times(1)).onChanged(expectData);
    }

}
