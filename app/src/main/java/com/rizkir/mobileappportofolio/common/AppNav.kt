package com.rizkir.mobileappportofolio.common

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rizkir.mobileappportofolio.features.home.navigation.homeNavigation

@Composable
fun AppNav(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.HomeScreen.route
    ) {
        homeNavigation()
    }
}