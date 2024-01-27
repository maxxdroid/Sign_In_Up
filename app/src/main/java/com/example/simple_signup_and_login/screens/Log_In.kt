package com.example.simple_signup_and_login.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.simple_signup_and_login.components.ClickableTexts
import com.example.simple_signup_and_login.components.RoundedCornersButton
import com.example.simple_signup_and_login.components.SignInTextFields
import com.example.simple_signup_and_login.components.SignUpText
import com.example.simple_signup_and_login.components.TermsTexts
import com.example.simple_signup_and_login.ui.theme.primaryA

@Composable
fun SignInPage(navController: NavHostController?=null) {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF57CC99)
    ) {
        Column (modifier = Modifier.fillMaxWidth()) {
            Box (
                modifier = Modifier
                    .background(
                        Color(0xFF80ED99),
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomEnd = 150.dp,
                            bottomStart = 150.dp,
                        )
                    )
            ) {
                Column (
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Spacer(modifier =  Modifier.heightIn(40.dp))
                    SignUpText()
                    Spacer(modifier =  Modifier.heightIn(40.dp))
                    SignInTextFields()
                    Box (
                        modifier = Modifier.padding(top = 30.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "Forgot Password")
                            Spacer(modifier =  Modifier.heightIn(20.dp))
                            RoundedCornersButton(text = "Log In") {
                            }
                            Spacer(modifier =  Modifier.heightIn(10.dp))
                            ClickableTexts(text = "or Sign Up") {
                                navController?.navigate("Sign Up")
                            }
                            Spacer(modifier =  Modifier.heightIn(30.dp))
                        }
                    }

                }
            }
            Box (
                modifier = Modifier.fillMaxSize().padding(30.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                TermsTexts()
            }
        }
    }
}

@Composable
@Preview
fun ViewSignUpPage() {
    SignInPage()
}