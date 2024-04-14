package com.eshc.goonersapp.core.data.di

import com.eshc.goonersapp.core.data.fake.FakeMatchRepositoryImpl
import com.eshc.goonersapp.core.domain.repository.MatchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
abstract class FakeDataModule {
    @Binds
    abstract fun bindsMatchRepository(matchRepository: FakeMatchRepositoryImpl): MatchRepository

}