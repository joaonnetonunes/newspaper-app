package com.ct.newsapp.di

import com.ct.newsapp.useCase.GetHeadLinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

class Module {

    @Provides
    fun provideGetHeadLinesUseCase(): GetHeadLinesUseCase {
        return GetHeadLinesUseCase()
    }
}
