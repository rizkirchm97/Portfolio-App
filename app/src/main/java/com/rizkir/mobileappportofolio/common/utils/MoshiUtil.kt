package com.rizkir.mobileappportofolio.common.utils

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object MoshiUtil {

    inline fun <reified T> fromJson(json: String, moshi: Moshi): List<T>? {
        val type = Types.newParameterizedType(List::class.java, T::class.java)
        val adapter: JsonAdapter<List<T>> = moshi.adapter(type)
        return try {
            adapter.fromJson(json)
        } catch (e: JsonDataException) {
            e.printStackTrace()
            null
        }
    }
}