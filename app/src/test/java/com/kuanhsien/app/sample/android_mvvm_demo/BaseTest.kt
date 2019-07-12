package com.kuanhsien.app.sample.android_mvvm_demo

import io.mockk.MockKAnnotations
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before

class BaseTest {

    @Before
    open fun init() {
        // For MockK annotation
        MockKAnnotations.init(this, relaxed = true)
        // or MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @After
    fun after() {
        unmockkAll()
        // or unmockkObject(MockObj)
    }
}