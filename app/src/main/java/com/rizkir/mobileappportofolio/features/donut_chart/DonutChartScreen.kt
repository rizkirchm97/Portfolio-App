package com.rizkir.mobileappportofolio.features.donut_chart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.rizkir.mobileappportofolio.common.components.ApplicationAppBar
import com.rizkir.mobileappportofolio.common.components.CircularProgress
import com.rizkir.mobileappportofolio.common.components.DonutChart
import com.rizkir.mobileappportofolio.common.components.LoadingContent
import com.rizkir.mobileappportofolio.data.datasources.dto.ChartDataItem
import com.rizkir.mobileappportofolio.domain.entities.DonutChartDataEntity

@Composable
internal fun DonutChartScreen(
    uiState: DonutChartUiState,
) {

    DonutChartScreen(
        uiState = uiState,
        success = { data, modifier ->
            DonutChartItem(
                data = data,
                modifier = modifier
            )
        },
        error = {}
    )

}

@Composable
fun DonutChartItem(data: ChartDataItem, modifier: Modifier) {
    Column(modifier = modifier) {

        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
internal fun DonutChartScreen(
    uiState: DonutChartUiState,
    success: @Composable (data: ChartDataItem, modifier: Modifier) -> Unit,
    error: @Composable () -> Unit
) {
    LoadingContent(
        isLoading = uiState is DonutChartUiState.Loading,
        loading = { CircularProgress() }
    ) {
        Scaffold(topBar = { ApplicationAppBar(title = "Donut Chart") })
        {
            val modifier = Modifier.padding(it)

            when (uiState) {
                is DonutChartUiState.Success -> {

                    DonutChart(modifier = modifier)
                    LazyColumn(modifier = modifier.background(Color.White)) {
                        val datas = uiState.data?.data
                        datas?.size?.let { size ->

                            items(count = size) { index ->
                                success(datas[index], modifier)
                            }
                        }
                    }
                }

                is DonutChartUiState.Error -> error()
                else -> Unit
            }

        }

    }

}

