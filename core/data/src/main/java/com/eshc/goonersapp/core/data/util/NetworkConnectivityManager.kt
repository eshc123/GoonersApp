package com.eshc.goonersapp.core.data.util

import kotlinx.coroutines.flow.Flow

interface NetworkConnectivityManager {
    val isOnline: Flow<Boolean>
}