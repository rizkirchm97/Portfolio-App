package com.rizkir.mobileappportofolio.features.donut_chart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun DonutChartItem(data: DonutChartDataEntity, modifier: Modifier) {
    Column(modifier = modifier) {

        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
internal fun DonutChartScreen(
    uiState: DonutChartUiState,
    success: @Composable (data: DonutChartDataEntity, modifier: Modifier) -> Unit,
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

                    if (uiState.data.isNullOrEmpty() || uiState.data.isEmpty()) {
                        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(text = "No Data", modifier = modifier.align(Alignment.Center))
                        }
                    } else {
                        LazyColumn(modifier = modifier.background(Color.White), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            item {
                                DonutChart(modifier = Modifier.padding(16.dp))
                            }
                            val datas = uiState.data
                            items(count = datas.size) { index ->
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

