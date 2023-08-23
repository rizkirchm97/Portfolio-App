package com.rizkir.mobileappportofolio.features.donut_chart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DonutChartRoute(
    viewModel: DonutChartViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    DonutChartScreen(uiState = uiState)

}