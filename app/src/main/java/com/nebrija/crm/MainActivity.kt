package com.nebrija.crm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import com.nebrija.crm.core.ui.theme.CRMTheme
import com.nebrija.crm.navigation.AppNavHost
import com.nebrija.crm.security.presentation.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val authViewModel by viewModels<AuthViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            Scaffold(
                snackbarHost = { SnackbarHost(snackbarHostState) },
                content = {
                   CRMTheme {
                        AppNavHost(authViewModel)
                    }
                }
            )
        }
    }
}