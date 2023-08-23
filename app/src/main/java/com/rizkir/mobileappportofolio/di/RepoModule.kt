package com.rizkir.mobileappportofolio.di

import com.rizkir.mobileappportofolio.data.repositories.PortfolioRepositoryImpl
import com.rizkir.mobileappportofolio.domain.repositories.PortfolioRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Singleton
    @Binds
    fun bindPortfolioRepository(repo: PortfolioRepositoryImpl): PortfolioRepository

}