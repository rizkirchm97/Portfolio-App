package com.rizkir.mobileappportofolio.domain.entities

import com.rizkir.mobileappportofolio.data.datasources.dto.ChartDataItem

data class DonutChartDataEntity(
    val label: String,
    val percentage: String,
    val data: List<ChartDataItem>
)
