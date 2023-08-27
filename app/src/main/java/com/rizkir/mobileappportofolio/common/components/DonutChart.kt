package com.rizkir.mobileappportofolio.common.components

import android.graphics.Typeface
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import co.yml.charts.common.components.Legends
import co.yml.charts.common.model.PlotType
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData

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

    val pieChartConfig =
        PieChartConfig(
            labelVisible = true,
            strokeWidth = 120f,
            labelColor = Color.Black,
            activeSliceAlpha = .9f,
            isEllipsizeEnabled = true,
            sliceLabelEllipsizeAt = TextUtils.TruncateAt.MIDDLE,
            labelTypeface = Typeface.defaultFromStyle(Typeface.BOLD),
            isAnimationEnable = true,
            showSliceLabels = true,
            chartPadding = 25,
            isClickOnSliceEnabled = true,
        )


    Column(modifier = modifier) {
        PieChart(
            modifier = modifier
                .fillMaxWidth()
                .height(250.dp),
            pieChartData,
            pieChartConfig
        ) {

        }
    }

}