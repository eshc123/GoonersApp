package com.eshc.goonersapp.core.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesGnrDatabase(
        @ApplicationContext context: Context,
    ): GnrDatabase = Room.databaseBuilder(
        context,
        GnrDatabase::class.java,
        "gnr-database",
    ).build()
}