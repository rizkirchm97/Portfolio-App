package com.rizkir.mobileappportofolio.common.utils


import com.rizkir.mobileappportofolio.data.datasources.dto.DataContainer
import com.rizkir.mobileappportofolio.data.datasources.dto.DonutChartData
import com.rizkir.mobileappportofolio.data.datasources.dto.LineChartData
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonReader

class CustomMoshiAdapter {

    @FromJson
    fun fromJson(reader: JsonReader): DataContainer {
        val jsonToken = reader.peek()
        return when (jsonToken) {
            JsonReader.Token.BEGIN_OBJECT -> {
                val dataObject = reader.readJsonValue() as LineChartData
                val result = dataObject.copy(month = dataObject.month)
                LineChartData(result.month)
            }
            JsonReader.Token.BEGIN_ARRAY -> {
                val dataArray = reader.readJsonValue() as List<DonutChartData>
                val mapDatas = dataArray.map { it.copy(data = it.data, label = it.label, percentage = it.percentage) }

               val result =  mapDatas.map {
                    DonutChartData(
                        it.label,
                        it.percentage,
                        it.data

                    )
                }
                result[0]
            }
            else -> throw JsonDataException("Invalid data format")
        }
    }

}