package com.rizkir.mobileappportofolio.features.donut_chart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.models.PieChartData
import com.rizkir.mobileappportofolio.common.utils.Resource
import com.rizkir.mobileappportofolio.data.datasources.dto.ChartDataItem
import com.rizkir.mobileappportofolio.domain.entities.DonutChartDataEntity
import com.rizkir.mobileappportofolio.domain.usecase.GetDonutChartDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DonutChartViewModel @Inject constructor(
    useCase: GetDonutChartDataUseCase
) : ViewModel() {

    val uiState: StateFlow<DonutChartUiState> = uiState(useCase)
        .stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(50_000),
            initialValue = DonutChartUiState.Loading
        )

    private fun uiState(useCase: GetDonutChartDataUseCase): Flow<DonutChartUiState> = flow {
        val result = useCase.invoke("donutChart")

        result.collect { data ->
            when (data) {
                is Resource.Loading -> {
                    emit(DonutChartUiState.Loading)
                }

                is Resource.Success -> {

                    val result = data.data
                    val donutDatas = mutableListOf<PieChartData.Slice>()

                    result?.forEach { donutChartEntity ->
                    donutDatas.add(
                        PieChartData.Slice()
                    )

                    }

                    val pieChartData = PieChartData(
                        slices = donutDatas,
                        plotType = PlotType.Donut
                    )

                    emit(DonutChartUiState.Success(
                        CombineDataHolder(
                            donutChartEntity = result,
                            pieChartData = pieChartData
                        )
                    ))
                }

                is Resource.Error -> {
                    emit(DonutChartUiState.Error(data.message.toString()))
                }
            }

        }

    }
}


sealed interface DonutChartUiState {
    object Loading : DonutChartUiState
    data class Success(val data: CombineDataHolder?) : DonutChartUiState
    data class Error(val message: String?) : DonutChartUiState
}
data class CombineDataHolder(
    val donutChartEntity: List<DonutChartDataEntity>?,
    val pieChartData: PieChartData
)