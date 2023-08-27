package com.rizkir.mobileappportofolio.domain.repositories

import com.rizkir.mobileappportofolio.common.utils.Resource
import com.rizkir.mobileappportofolio.domain.entities.DonutChartDataEntity
import com.rizkir.mobileappportofolio.domain.entities.LineChartDataEntity
import kotlinx.coroutines.flow.Flow

interface PortfolioRepository {
suspend fun getDonutChartData(typeChart: String): Flow<Resource<List<DonutChartDataEntity>>>
suspend fun getLineChartData(typeChart: String): Flow<Resource<LineChartDataEntity>>
}