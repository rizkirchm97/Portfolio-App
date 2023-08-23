package com.rizkir.mobileappportofolio.data.datasources.dto

import com.squareup.moshi.Json

data class ChartDataItem(
    @field:Json(name = "trx_date")
    val trxDate: String,
    @field:Json(name = "nominal")
    val nominal: Int
)
