package com.rizkir.mobileappportofolio.common.utils

import android.graphics.Typeface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import co.yml.charts.ui.piechart.models.PieChartConfig

/**
 * created by RIZKI RACHMANUDIN on 31/08/2023
 */
object ChartUtil {

    val donutChartConfig =
        PieChartConfig(
            labelVisible = true,
            strokeWidth = 120f,
            labelColor = Color.Black,
            activeSliceAlpha = .9f,
            isEllipsizeEnabled = true,
            labelTypeface = Typeface.defaultFromStyle(Typeface.BOLD),
            isAnimationEnable = true,
            chartPadding = 25,
            labelFontSize = 42.sp,
        )
}