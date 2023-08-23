package com.rizkir.mobileappportofolio.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DonutLarge
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreenRoute(
    var route: String,
    var icon: ImageVector,
    var title: String
) {
    object DonutChart : BottomBarScreenRoute("donutChart", Icons.Default.DonutLarge, "Donut Chart")
    object LineChart : BottomBarScreenRoute("lineChart", Icons.Default.ShowChart, "Line Chart")
}
