package com.rizkir.mobileappportofolio.features.line_chart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rizkir.mobileappportofolio.common.BottomBarScreenRoute
import com.rizkir.mobileappportofolio.features.line_chart.LineChartRoute

fun NavGraphBuilder.lineChartNavigation() {
    composable(route = BottomBarScreenRoute.LineChart.route) {
        LineChartRoute()
    }
}