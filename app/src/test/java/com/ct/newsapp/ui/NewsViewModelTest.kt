package com.ct.newsapp.ui

import androidx.lifecycle.MutableLiveData
import com.ct.newsapp.model.HttpResponse
import com.ct.newsapp.model.ResponseItemSuccess
import com.ct.newsapp.service.Constants
import com.ct.newsapp.useCase.GetHeadLinesUseCase
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test

class NewsViewModelTest {
    private val headLinesUseCase = mockk<GetHeadLinesUseCase>()

    private val sut = NewsViewModel(headLinesUseCase)

    @Test
    fun `return httpResponse successful when request succeeds`() {
        val httpResponseSuccess = MutableLiveData<HttpResponse<ResponseItemSuccess?>>()

        every { headLinesUseCase.getTopHeadLines() } returns httpResponseSuccess

        sut.observeHeadlines()

        assertEquals(sut.observeHeadlines(), httpResponseSuccess)
    }
}
