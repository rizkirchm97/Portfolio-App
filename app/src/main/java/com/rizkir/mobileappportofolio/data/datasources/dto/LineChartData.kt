package com.rizkir.mobileappportofolio.data.datasources.dto

import com.squareup.moshi.Json

data class LineChartData(
    @field:Json(name = "month")
    val month: List<Int>
) : DataContainer
