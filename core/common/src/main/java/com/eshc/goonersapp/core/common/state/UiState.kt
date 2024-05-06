package com.eshc.goonersapp.core.common.state

sealed class UiState<out T> {
    data class Success<T>(
        val data : T
    ) : UiState<T>()

    data object Error : UiState<Nothing>()

    data object Loading : UiState<Nothing>()

}