package com.rizkir.mobileappportofolio.features.donut_chart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rizkir.mobileappportofolio.common.BottomBarScreenRoute
import com.rizkir.mobileappportofolio.features.donut_chart.DonutChartRoute


fun NavGraphBuilder.donutChartNavigation() {
    composable(route = BottomBarScreenRoute.DonutChart.route) {
        DonutChartRoute()
    }
}