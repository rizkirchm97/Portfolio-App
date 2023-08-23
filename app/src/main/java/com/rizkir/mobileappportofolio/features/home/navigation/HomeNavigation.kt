package com.rizkir.mobileappportofolio.features.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rizkir.mobileappportofolio.common.BottomBarScreenRoute
import com.rizkir.mobileappportofolio.common.NavRoute
import com.rizkir.mobileappportofolio.features.home.HomeScreen

fun NavGraphBuilder.homeNavigation() {
    composable(route = NavRoute.HomeScreen.route) {
        HomeScreen()
    }


}