package com.rizkir.mobileappportofolio.features.detail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.compose.composable
import com.rizkir.mobileappportofolio.common.NavRoute
import com.rizkir.mobileappportofolio.features.detail.PortfolioDetailRoute

fun NavGraphBuilder.portfolioDetailNavigation() {
    composable(route = NavRoute.DetailScreen.route) {
        PortfolioDetailRoute()
    }

}