package com.mobillabor.moblab.di

import com.mobillabor.moblab.network.LOTRService
import com.mobillabor.moblab.persistence.CharacterDao
import com.mobillabor.moblab.persistence.QuoteDao
import com.mobillabor.moblab.ui.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        lotrService: LOTRService,
        characterDao: CharacterDao,
    ): MainRepository {
        return MainRepository(lotrService, characterDao)
    }
}