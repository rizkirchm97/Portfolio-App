package com.rizkir.mobileappportofolio.common.components

import android.graphics.Typeface
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.common.components.Legends
import co.yml.charts.common.model.PlotType
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.piechart.charts.DonutPieChart
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import com.rizkir.mobileappportofolio.common.utils.ChartUtil

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DonutChart(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val pieChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice("MI", 15f, Color(0xFF58BDFF)),
            PieChartData.Slice("Iphone", 35f, Color(0xFF125B7F)),
            PieChartData.Slice("Windows", 10f, Color(0xFF092D40)),
            PieChartData.Slice("Pixel", 10f, Color(0xFF092D10)),
            PieChartData.Slice("Samsung", 20f, Color(0xFF092D70)),
            PieChartData.Slice("Oneplus", 0f, Color(0xFF092D80)),
        ),
        plotType = PlotType.Donut
    )




    Column(modifier = modifier) {
        DonutPieChart(
            modifier = modifier
                .fillMaxSize()
                .height(250.dp),
            pieChartData,
            ChartUtil.donutChartConfig
        ) {

        }
    }

}