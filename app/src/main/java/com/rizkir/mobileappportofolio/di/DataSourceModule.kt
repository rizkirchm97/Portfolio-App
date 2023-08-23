package com.rizkir.mobileappportofolio.di

import android.content.Context
import com.rizkir.mobileappportofolio.data.datasources.LocalDataSource
import com.rizkir.mobileappportofolio.data.datasources.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindLocalDataSource(dataSource: LocalDataSourceImpl): LocalDataSource
}
