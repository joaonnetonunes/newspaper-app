package com.ct.newsapp.useCase

import androidx.lifecycle.liveData
import com.ct.newsapp.model.HttpResponse
import com.ct.newsapp.service.ConnectionBuilder
import com.ct.newsapp.service.Constants
import java.lang.Exception

class GetHeadLinesUseCase {
    fun getTopHeadLines() = liveData {
        val map = mutableMapOf<String, String>()
        map["country"] = "us"
        map["apiKey"] = Constants.API_KEY
        val response = ConnectionBuilder().newsService.getTopHeadLines(map)

        if (response.isSuccessful) {
            emit(HttpResponse.Success(data = response.body()))
        } else {
            emit(HttpResponse.Error(exception = Exception("Failed to load News")))
        }
    }
}
