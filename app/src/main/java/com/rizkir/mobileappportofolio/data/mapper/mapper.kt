package com.rizkir.mobileappportofolio.data.mapper

import com.rizkir.mobileappportofolio.data.datasources.dto.ChartData
import com.rizkir.mobileappportofolio.data.datasources.dto.ChartDataItem
import com.rizkir.mobileappportofolio.data.datasources.dto.DonutChartData
import com.rizkir.mobileappportofolio.data.datasources.dto.LineChartData
import com.rizkir.mobileappportofolio.domain.entities.ChartDataEntity
import com.rizkir.mobileappportofolio.domain.entities.ChartDataItemEntity
import com.rizkir.mobileappportofolio.domain.entities.DonutChartDataEntity
import com.rizkir.mobileappportofolio.domain.entities.LineChartDataEntity

fun ChartData.toEntity() = ChartDataEntity(
    type = type,
    data = data
)

fun ChartDataEntity.toDto() = ChartData(
    type = type,
    data = data
)

fun DonutChartData.toEntity() = DonutChartDataEntity(
    label = label,
    percentage = percentage,
    data = data
)

fun DonutChartDataEntity.toDto() = DonutChartData(
    label = label,
    percentage = percentage,
    data = data
)

fun ChartDataItem.toEntity() = ChartDataItemEntity(
    trxDate = trxDate,
    nominal = nominal
)

fun ChartDataItemEntity.toDto() = ChartDataItem(
    trxDate = trxDate,
    nominal = nominal
)

fun LineChartData.toEntity() = LineChartDataEntity(
    month = month
)

fun LineChartDataEntity.toDto() = LineChartData(
    month = month
)
