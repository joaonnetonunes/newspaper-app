package com.ct.newsapp.model

import java.io.Serializable
import java.util.ArrayList

open class ResponseItemSuccess : Serializable {
    var status: String? = null
    var totalResults: Int? = null
    var articles: ArrayList<Article>? = null
}
