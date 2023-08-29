package com.rizkir.mobileappportofolio.common.utils

import android.content.Context
import com.rizkir.mobileappportofolio.data.datasources.dto.ChartData
import com.rizkir.mobileappportofolio.data.datasources.dto.ChartDataItem
import com.rizkir.mobileappportofolio.data.datasources.dto.DonutChartData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray

/**
 * created by RIZKI RACHMANUDIN on 28/08/2023
 */
class JsonUtil(private val context: Context) {

    private suspend fun getJsonDataFromAsset(fileName: String): String {
        return withContext(Dispatchers.IO) {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        }
    }

    suspend fun loadDataChart(typeChart: String): List<ChartData> {
        val list = mutableListOf<ChartData>()
        val json = getJsonDataFromAsset("Portfolio.json")
        val responseJsonArray = JSONArray(json)
        for (i in 0 until responseJsonArray.length()) {
            val jsonObject = responseJsonArray.getJSONObject(i)
            var data: Any?
            val type = jsonObject.getString("type")
            if (type.equals(typeChart)) {
                val donutChartDatas = jsonObject.getJSONArray("data")
                val donutChartData = mutableListOf<DonutChartData>()

                for (item in 0..donutChartDatas.length()) {
                    val dataChartItems = mutableListOf<ChartDataItem>()

                    val label = donutChartDatas.getJSONObject(item).getString("label")
                    val percentage = donutChartDatas.getJSONObject(item).getString("percentage")
                    val datas = donutChartDatas.getJSONObject(item).getJSONArray("data")

                    for (i in 0 until datas.length()) {
                        val trxDate = datas.getJSONObject(i).getString("trx_date")
                        val nominal = datas.getJSONObject(i).getInt("nominal")
                        dataChartItems.add(ChartDataItem(trxDate, nominal))
                    }

                    donutChartData.add(DonutChartData(label, percentage, dataChartItems))

                }

                data = donutChartData
            } else {
                data = jsonObject.getJSONObject("data")
            }

            if (data != null) {
                list.add(ChartData(type, data))
            }
        }

        return list
    }

}