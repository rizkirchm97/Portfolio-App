package com.rizkir.mobileappportofolio.common.utils

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object MoshiUtil {

    inline fun <reified T> fromJson(json: String, moshi: Moshi): T? {
        val typeObject = Types.newParameterizedType(T::class.java)
        val adapterObject: JsonAdapter<T> = moshi.adapter(typeObject)

        return try {
            adapterObject.fromJson(json)
        } catch (e: JsonDataException) {
            e.printStackTrace()
            null
        }
    }
}