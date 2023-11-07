package com.nebrija.crm.security.application.response

sealed class Response<out R> {
    data class Success<out R>(val result: R) : Response<R>()
    data class Failure(val exception: Exception) : Response<Nothing>()
    object Loading : Response<Nothing>()
}
