package com.rizkir.mobileappportofolio.data.datasources.dto

import com.squareup.moshi.Json

data class ChartData(
    @field:Json(name = "type")
    val type: String,
    @field:Json(name = "data")
    val data: Any
)
