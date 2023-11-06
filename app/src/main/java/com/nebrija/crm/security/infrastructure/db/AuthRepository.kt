package com.nebrija.crm.security.infrastructure.db

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.nebrija.crm.core.utils.await
import com.nebrija.crm.security.application.response.Response
import com.nebrija.crm.security.domain.repository.AuthRepository
import javax.inject.Inject
class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Response.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun signup(name: String, email: String, password: String): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            result.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())?.await()
            return Response.Success(result.user!!)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }
}