package com.androiddevs.mvvmnewsapp.util

// instructed by Google itself

// can be used for any projects to use for the responses retrieved from the APIs


sealed class Resource<T>(
    val data : T? = null,
    val message : String? = null
) {

    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}