package com.nebrija.crm.di

import com.google.firebase.auth.FirebaseAuth
import com.nebrija.crm.security.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.nebrija.crm.security.infrastructure.db.AuthRepository as AuthRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl
}