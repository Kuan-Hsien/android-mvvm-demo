package com.kuanhsien.app.sample.android_mvvm_demo;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import org.junit.Before;
import org.junit.Rule;
import org.mockito.MockitoAnnotations;


public class BaseTest {

    // Execute everything in foreground thread (synchronized)
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}
