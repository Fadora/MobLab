package com.mobillabor.moblab.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.mobillabor.moblab.R
import com.mobillabor.moblab.persistence.AppDatabase
import com.mobillabor.moblab.persistence.CharacterDao
import com.mobillabor.moblab.persistence.QuoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "LOTRDB"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCharacterDao(appDatabase: AppDatabase): CharacterDao {
        return appDatabase.characterDao()
    }

    @Provides
    @Singleton
    fun provideQuoteDao(appDatabase: AppDatabase): QuoteDao {
        return appDatabase.quoteDao()
    }
}