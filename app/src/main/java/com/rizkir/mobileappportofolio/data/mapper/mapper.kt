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
    undefinedData = data
)

fun LinkedHashMap<*, *>.toDonutChartDataEntity(): DonutChartDataEntity {
    val label = this["label"] as? String ?: ""
    val percentage = this["percentage"] as? String ?: ""
    val data = this["data"] as? List<LinkedHashMap<*, *>>

    val dataEntries = data?.map {
        val trxDate = it["trx_date"] as? String ?: ""
        val nominal = (it["nominal"] as? Int) ?: 0
        // Create and return a DataEntry instance
        ChartDataItem(trxDate, nominal)
    } ?: emptyList()

    return DonutChartDataEntity(label, percentage, dataEntries)
}

fun List<ChartDataItem>.mapToChartDataItemEntity() = map { it.toEntity() }

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

fun List<ChartDataItemEntity>.mapToChartDataItem() = map { it.toDto() }

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
