package com.eshc.goonersapp.core.data.mapper

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.network.model.NetworkResult

fun <T,R> NetworkResult<T>.toDataResult(
    convert : (T) -> R
) : DataResult<R> {
    return when(this){
        is NetworkResult.Success -> {
            DataResult.Success(convert(this.data))
        }
        is NetworkResult.Error -> {
            DataResult.Failure(code = this.code, message = this.message)
        }
        is NetworkResult.Exception -> {
            DataResult.Failure(code = 0, null)
        }
    }
}