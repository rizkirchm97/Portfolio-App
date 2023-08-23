package com.rizkir.mobileappportofolio.domain.usecase

import com.rizkir.mobileappportofolio.domain.repositories.PortfolioRepository
import javax.inject.Inject

class GetDonutChartDataUseCase @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    suspend operator fun invoke(typeChart: String) = portfolioRepository.getDonutChartData(typeChart)
}