package com.rizkir.mobileappportofolio.data.repositories

import android.util.Log
import com.rizkir.mobileappportofolio.common.utils.Resource
import com.rizkir.mobileappportofolio.data.datasources.LocalDataSource
import com.rizkir.mobileappportofolio.data.datasources.dto.DonutChartData
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


    override suspend fun getDonutChartData(typeChart: String): Flow<Resource<List<DonutChartDataEntity>>> =
        flow {


            try {
                val chartData = localDataSource.getChartDataFromAsset(typeChart).map {
                    it.toEntity()
                }

                val result = (chartData[0].undefinedData as List<DonutChartData>)
                    .map { it.toEntity() }
                    .also { alsoData ->
                        alsoData.map { it.data.map { donutChartItem ->
                            donutChartItem.toEntity() } } }
                emit(Resource.Success(result))

            } catch (e: Exception) {
                emit(Resource.Error(e.message))
            }


        }

    override suspend fun getLineChartData(typeChart: String): Flow<Resource<LineChartDataEntity>> =
        flow {
            try {
                val chartData = localDataSource.getChartDataFromAsset("Portfolio.json")
                    .filter { it.type == typeChart }.map { it.toEntity() }
                for (i in chartData.indices) {
                    emit(Resource.Success((chartData[i].undefinedData as LineChartDataEntity)))
                }
            } catch (e: Exception) {
                emit(Resource.Error(e.message))
            }
        }

}