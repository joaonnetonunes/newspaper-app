package com.ct.newsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ct.newsapp.model.HttpResponse
import com.ct.newsapp.model.ResponseItemSuccess
import com.ct.newsapp.useCase.GetHeadLinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val headLinesUseCase: GetHeadLinesUseCase,
) : ViewModel() {

    fun observeHeadlines(): LiveData<HttpResponse<ResponseItemSuccess?>> =
        headLinesUseCase.getTopHeadLines()
}
