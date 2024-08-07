package com.example.storeapp.network

data class ApiCallState<out T>(val status: Status, val data : T?, val message : String?){
    companion object{
        fun <T> success(data : T?): ApiCallState<T?>{
            return ApiCallState(Status.SUCCESS, data, null)
        }

        fun <T> error(msg : String?) : ApiCallState<T?>{
            return ApiCallState(Status.ERROR, null, msg)
        }

        fun <T> error(msg: String?, data : T?) : ApiCallState<T?>{
            return ApiCallState(Status.ERROR, data, msg)
        }

        fun <T> loading() : ApiCallState<T?>{
            return ApiCallState(Status.LOADING, null, null)
        }
    }
}

enum class Status{
    LOADING,
    ERROR,
    SUCCESS
}
