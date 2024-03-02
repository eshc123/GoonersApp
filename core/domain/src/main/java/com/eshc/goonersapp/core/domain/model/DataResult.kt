package com.eshc.goonersapp.core.domain.model

sealed class DataResult<T>  {
    class Success<T>(val data : T) : DataResult<T>()
    class Failure<T>(val code : Int, val message: String?) : DataResult<T>()
}