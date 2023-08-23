package com.rizkir.mobileappportofolio.common

sealed class NavRoute(val route: String) {
    object HomeScreen : NavRoute("homeScreen")
    object DetailScreen : NavRoute("detailScreen")
}
