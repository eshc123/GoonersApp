package com.eshc.goonersapp.core.database.model

sealed class DatabaseResult<T> {
    class Success<T>(val data: T) : DatabaseResult<T>()
    class Failure<T>: DatabaseResult<T>()
}

suspend fun <T : Any> handleDatabase(
    execute: suspend () -> T?
): DatabaseResult<T> {
    return try {
        execute().let {
            if(it == null) DatabaseResult.Failure() else  DatabaseResult.Success(it)
        }
    } catch (e: Throwable) {
        DatabaseResult.Failure()
    }
}

suspend fun <T : Any> DatabaseResult<T>.onSuccess(
    executable: suspend (T) -> Unit
): DatabaseResult<T> = apply {
    if (this is DatabaseResult.Success<T>) {
        executable(data)
    }
}

suspend fun <T : Any> DatabaseResult<T>.onFailure(
    executable: suspend () -> Unit
): DatabaseResult<T> = apply {
    if (this is DatabaseResult.Failure<T>) {
        executable()
    }
}

suspend fun DatabaseResult<Unit>.onComplete(
    executable: suspend () -> Unit
): DatabaseResult<Unit> = apply {
    executable()
}