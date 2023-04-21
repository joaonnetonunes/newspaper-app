package com.ct.newsapp.model

import java.io.Serializable

class ResponseItemFailure : Serializable {
    var status: String? = null
    var code: String? = null
    var message: String? = null
}
