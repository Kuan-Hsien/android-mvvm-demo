package com.kuanhsien.app.sample.android_mvvm_demo.viewmodel;

import com.kuanhsien.app.sample.android_mvvm_demo.BaseTest;
import com.kuanhsien.app.sample.android_mvvm_demo.data.model.InfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.data.observable.ObservableInfoModel;
import com.kuanhsien.app.sample.android_mvvm_demo.repository.InfoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;

public class InfoViewModelTest extends BaseTest {

    // Mock Object
    @Mock
    InfoRepository mockRepository;
    @Mock
    ObservableInfoModel mockObservableInfoModel;

    // InjectMock: Inject Mock Objects into ViewModel
    @InjectMocks
    InfoViewModel viewModel = new InfoViewModel();


    // prepare testing data
    private String testId = "test";
    private InfoModel expectData = new InfoModel();


    @Before
    @Override public void setUp() {
        super.setUp();

        // init (Mock void method with mockito)
        doAnswer(new Answer<Void>() {

            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {

                // assert to test calling func mockRepository.getInfo(viewModel, testId)
                Object[] arguments = invocation.getArguments();

                assert(arguments != null);
                assert(arguments.length == 2);
                assert(arguments[0] != null);
                assert(arguments[1] != null);

                // simulate query data through repository and invoke callback
                viewModel.onCompleted(expectData);

                return null;
            }
        }).when(mockRepository).getInfo(viewModel, testId);
    }


    @Test
    public void verifyPrepareData() {
        viewModel.prepareData(testId);

        // verify
        Mockito.verify(mockRepository, times(1)).getInfo(viewModel, testId);
        Mockito.verify(mockObservableInfoModel, times(1)).setValue(expectData);
    }

}
