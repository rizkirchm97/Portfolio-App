package com.rizkir.mobileappportofolio.data.datasources

import com.rizkir.mobileappportofolio.common.utils.JsonHelper
import com.rizkir.mobileappportofolio.data.datasources.dto.ChartData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val jsonHelper: JsonHelper) : LocalDataSource {
    override suspend fun getChartDataFromAsset(fileName: String): List<ChartData> = withContext(Dispatchers.IO) {

        return@withContext jsonHelper.loadDataChart(fileName)
    }


}