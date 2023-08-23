package com.rizkir.mobileappportofolio.data.datasources

import com.rizkir.mobileappportofolio.data.datasources.dto.ChartData

interface LocalDataSource {
    suspend fun getChartDataFromAsset(fileName: String): List<ChartData>
}