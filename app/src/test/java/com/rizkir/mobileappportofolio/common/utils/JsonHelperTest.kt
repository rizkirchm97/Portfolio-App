package com.rizkir.mobileappportofolio.common.utils

import android.app.Application
import android.content.Context
import com.rizkir.mobileappportofolio.data.datasources.dto.ChartData
import com.rizkir.mobileappportofolio.data.datasources.dto.ChartDataItem
import com.rizkir.mobileappportofolio.data.datasources.dto.DonutChartData
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import javax.inject.Inject

/**
 * created by RIZKI RACHMANUDIN on 30/08/2023
 */


class JsonHelperTest {


    private lateinit var jsonHelper: JsonHelper



    @BeforeEach
    fun beforeEach() {
//        jsonHelper = JsonHelper(context)
    }

    @Test
    @DisplayName("should load Donut Chart Data")
    fun shouldLoadDonutChartData() = runTest {
        val jsonHelperTest = jsonHelper.loadDataChart("donutChart")

        assertEquals(expected, jsonHelperTest)
    }

    val expected = listOf(
        ChartData(
            type = "donutChart",
            data = listOf(
                DonutChartData(
                    label = "Tarik Tunai",
                    percentage = "55",
                    listOf(
                        ChartDataItem(
                            trxDate = "21/01/2023",
                            nominal = 1_000_000
                        ),
                        ChartDataItem(
                            trxDate = "20/01/2023",
                            nominal = 500_000
                        ),
                        ChartDataItem(
                            trxDate = "19/01/2023",
                            nominal = 1000000

                        ),

                        )
                ),
                DonutChartData(
                    label = "QRIS Payment",
                    percentage = "7.7",
                    listOf(
                        ChartDataItem(
                            trxDate = "21/01/2023",
                            nominal = 159000
                        ),
                        ChartDataItem(
                            trxDate = "20/01/2023",
                            nominal = 35000
                        ),
                        ChartDataItem(
                            trxDate = "19/01/2023",
                            nominal = 1500

                        ),

                        )
                ),
                DonutChartData(
                    label = "Topup Gopay",
                    percentage = "31",
                    listOf(
                        ChartDataItem(
                            trxDate = "21/01/2023",
                            nominal = 200000
                        ),
                        ChartDataItem(
                            trxDate = "20/01/2023",
                            nominal = 195000
                        ),
                        ChartDataItem(
                            trxDate = "19/01/2023",
                            nominal = 5000000

                        ),

                        )
                ),
                DonutChartData(
                    label = "Lainnya",
                    percentage = "6.3",
                    listOf(
                        ChartDataItem(
                            trxDate = "21/01/2023",
                            nominal = 1000000
                        ),
                        ChartDataItem(
                            trxDate = "20/01/2023",
                            nominal = 500000
                        ),
                        ChartDataItem(
                            trxDate = "19/01/2023",
                            nominal = 1000000

                        ),

                        )
                )
            )
        )
    )
}