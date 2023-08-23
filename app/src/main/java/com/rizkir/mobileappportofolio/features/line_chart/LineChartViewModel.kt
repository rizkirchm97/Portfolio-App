package com.rizkir.mobileappportofolio.features.line_chart

import androidx.lifecycle.ViewModel
import com.rizkir.mobileappportofolio.domain.usecase.GetLineChartDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LineChartViewModel @Inject constructor(
    useCase: GetLineChartDataUseCase
) : ViewModel() {
}