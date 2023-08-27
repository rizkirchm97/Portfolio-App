package com.rizkir.mobileappportofolio.data.datasources

import android.content.Context
import com.rizkir.mobileappportofolio.common.utils.MoshiUtil
import com.rizkir.mobileappportofolio.data.datasources.dto.ChartData
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val context: Context, private val moshi: Moshi) : LocalDataSource {
    override suspend fun getChartDataFromAsset(fileName: String): List<ChartData> {
        val json = getJsonDataFromAsset(fileName)
        val result = MoshiUtil.fromJson<ChartData>(json, moshi) ?: emptyList()
        return result
    }

    private suspend fun getJsonDataFromAsset(fileName: String): String {
        return withContext(Dispatchers.IO) {
            try {
                context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ex: Exception) {
                ex.printStackTrace()
                return@withContext ""
            }
        }

    }
}