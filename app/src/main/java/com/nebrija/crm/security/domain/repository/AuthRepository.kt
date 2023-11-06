package com.nebrija.crm.security.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.nebrija.crm.security.application.response.Response

interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun login(email: String, password: String): Response<FirebaseUser>
    suspend fun signup(name: String, email: String, password: String): Response<FirebaseUser>
    fun logout()
}