package com.rizkir.mobileappportofolio.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rizkir.mobileappportofolio.common.BottomBarScreenRoute
import com.rizkir.mobileappportofolio.features.home.navigation.HomeScreenGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
) {

    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) {
        val modifier = Modifier
            .fillMaxSize()
            .padding(it)


        HomeScreenGraph(
            navHostController = navController
        )

    }

}
@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarScreenRoute.DonutChart,
        BottomBarScreenRoute.LineChart

    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
//    if (bottomBarDestination) {
        BottomNavigation(backgroundColor = Color.White,
            modifier = Modifier.background(
                if (bottomBarDestination) Color.Cyan.copy(alpha = 0.5F) else Color.Transparent,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            ) {
            screens.forEach { screen ->
                addBottomBarItems(screen = screen, navController = navController, currentRoute = currentDestination)
            }
        }
//    }


}

@Composable
fun RowScope.addBottomBarItems(
    screen: BottomBarScreenRoute,
    navController: NavHostController,
    currentRoute: NavDestination?
){
    BottomNavigationItem(

        selected = currentRoute?.hierarchy?.any { it.route == screen.route } == true,
        onClick = { navController.navigate(screen.route) {
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true
        } },
        icon = { Icon(
        imageVector = screen.icon ,
        contentDescription = "nav icon"
    )}
    )

}


