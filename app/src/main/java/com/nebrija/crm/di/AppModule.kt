package com.nebrija.crm.di

import com.google.firebase.auth.FirebaseAuth
import com.nebrija.crm.security.infrastructure.db.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun providesAuthRepository(impl: AuthRepository): AuthRepository = impl
}