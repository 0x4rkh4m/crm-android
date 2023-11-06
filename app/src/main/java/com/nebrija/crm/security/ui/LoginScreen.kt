package com.nebrija.crm.security.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.nebrija.crm.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen()
{
    BackgroundImage()
    LoginForm()
}

@Composable
fun BackgroundImage() {
    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Background Image")
}

@Composable
fun LoginForm(){}