package com.nebrija.crm.security.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.nebrija.crm.security.application.response.Response
import com.nebrija.crm.security.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Response<FirebaseUser>?> = _loginFlow

    private val _signupFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val signupFlow: StateFlow<Response<FirebaseUser>?> = _signupFlow

    val currentUser: FirebaseUser?
        get() = repository.currentUser

    init {
        if (repository.currentUser != null) {
            _loginFlow.value = Response.Success(repository.currentUser!!)
        }
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginFlow.value = Response.Loading
        val result = repository.login(email, password)
        _loginFlow.value = result
    }

    fun signup(name: String, email: String, password: String) = viewModelScope.launch {
        _signupFlow.value = Response.Loading
        val result = repository.signup(name, email, password)
        _signupFlow.value = result
    }

    fun logout() {
        repository.logout()
        _loginFlow.value = null
        _signupFlow.value = null
    }
}