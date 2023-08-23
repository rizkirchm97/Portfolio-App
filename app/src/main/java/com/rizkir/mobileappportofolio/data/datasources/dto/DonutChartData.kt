package com.rizkir.mobileappportofolio.data.datasources.dto

import com.squareup.moshi.Json

data class DonutChartData(
    @field:Json(name = "label")
    val label: String,
    @field:Json(name = "percentage")
    val percentage: String,
    @field:Json(name = "data")
    val data: List<ChartDataItem>
)
