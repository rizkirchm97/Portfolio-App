package com.rizkir.mobileappportofolio.features.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rizkir.mobileappportofolio.common.BottomBarScreenRoute
import com.rizkir.mobileappportofolio.common.NavRoute
import com.rizkir.mobileappportofolio.features.detail.navigation.portfolioDetailNavigation
import com.rizkir.mobileappportofolio.features.donut_chart.navigation.donutChartNavigation
import com.rizkir.mobileappportofolio.features.line_chart.navigation.lineChartNavigation

@Composable
fun HomeScreenGraph(
    navHostController: NavHostController,
) {

    NavHost(navController = navHostController, route = NavRoute.HomeScreen.route, startDestination = BottomBarScreenRoute.DonutChart.route) {

        donutChartNavigation()

        lineChartNavigation()

        portfolioDetailNavigation()
    }
}