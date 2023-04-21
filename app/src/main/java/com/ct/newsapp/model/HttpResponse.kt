package com.ct.newsapp.model

import java.lang.Exception

sealed class HttpResponse<out R> {
    data class Success<out T>(val data: T?) : HttpResponse<T?>()
    data class Error(val exception: Exception) : HttpResponse<Nothing>()
}
