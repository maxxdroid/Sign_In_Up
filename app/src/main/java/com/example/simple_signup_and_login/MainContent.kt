package com.example.simple_signup_and_login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simple_signup_and_login.screens.SignInPage
import com.example.simple_signup_and_login.screens.SignUp

@Composable
fun MainContent () {
    val navController = rememberNavController()
    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = "Sign In",
            builder = {
                composable("Sign In") {
                    SignInPage(navController)
                }
                composable("Sign Up") {
                    SignUp(navController)
                }
            }
        )
    }
}