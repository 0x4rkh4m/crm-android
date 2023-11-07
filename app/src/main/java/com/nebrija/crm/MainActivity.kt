package com.nebrija.crm

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nebrija.crm.core.ui.theme.CRMTheme
import com.nebrija.crm.navigation.AppNavHost
import com.nebrija.crm.security.presentation.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CRMTheme {
                AppNavHost(viewModel)
            }
        }
    }
}
