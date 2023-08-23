package com.rizkir.mobileappportofolio.data.repositories

import com.rizkir.mobileappportofolio.common.utils.Resource
import com.rizkir.mobileappportofolio.data.datasources.LocalDataSource
import com.rizkir.mobileappportofolio.data.mapper.toEntity
import com.rizkir.mobileappportofolio.domain.entities.DonutChartDataEntity
import com.rizkir.mobileappportofolio.domain.entities.LineChartDataEntity
import com.rizkir.mobileappportofolio.domain.repositories.PortfolioRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PortfolioRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : PortfolioRepository {


    override suspend fun getDonutChartData(typeChart: String): Flow<Resource<DonutChartDataEntity>> =
        flow {

            try {
                val chartData = localDataSource.getChartDataFromAsset("Portfolio.json")
                    .filter { it.type == typeChart }.map { it.toEntity() }
                for (i in chartData.indices) {
                    emit(Resource.Success((chartData[i].data as DonutChartDataEntity)))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message))
            }


        }

    override suspend fun getLineChartData(typeChart: String): Flow<Resource<LineChartDataEntity>> = flow {
        try {
            val chartData = localDataSource.getChartDataFromAsset("Portfolio.json")
                .filter { it.type == typeChart }.map { it.toEntity() }
            for (i in chartData.indices) {
                emit(Resource.Success((chartData[i].data as LineChartDataEntity)))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }

}