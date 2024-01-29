package com.example.simple_signup_and_login.screens

import androidx.compose.animation.Animatable
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.simple_signup_and_login.components.ClickableTexts
import com.example.simple_signup_and_login.components.RoundedCornersButton
import com.example.simple_signup_and_login.components.SignInDesignCircle
import com.example.simple_signup_and_login.components.SignInTextFields
import com.example.simple_signup_and_login.components.SignUpText
import com.example.simple_signup_and_login.components.TermsTexts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.drawscope.translate
import com.example.simple_signup_and_login.components.SignUpTextFields
import com.example.simple_signup_and_login.ui.theme.primaryA

@Composable
fun SignInPage(navController: NavHostController?=null) {
    
    val isSignUp = remember { mutableStateOf(false)}

//    LaunchedEffect(Unit) {
//        if (!isSignIn.value) {
//            isSignIn.value= true
//        }
//    }
//

    val animateCircle = animateIntAsState(
        targetValue = if (isSignUp.value) 1200 else -500,
        animationSpec = tween(
            delayMillis = 1,
            durationMillis = 1000
        ), label = ""
    )

//    val animateCircle
    
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF80ED99)
    ) {
        DesignCircle(Vals = animateCircle.value)
        Column (modifier = Modifier.fillMaxWidth()) {
            Box (
            ) {
                Column (
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Spacer(modifier =  Modifier.heightIn(40.dp))
                    SignUpText()
                    Spacer(modifier =  Modifier.heightIn(40.dp))
                    if (isSignUp.value) {
                        SignUpTextFields()
                    } else {
                        SignInTextFields()
                    }
                    Box (
                        modifier = Modifier.padding(top = 30.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            if (isSignUp.value) {
                                Spacer(modifier =  Modifier.heightIn(40.dp))
                                RoundedCornersButton(text = "Sign Up") {
                                }
                            } else {
                                Text(text = "Forgot Password")
                                Spacer(modifier =  Modifier.heightIn(20.dp))
                                RoundedCornersButton(text = "Log In") {
                                }
                            }

                            Spacer(modifier =  Modifier.heightIn(10.dp))
                            if (isSignUp.value) {
                                ClickableTexts(text = "or Log In") {
                                    if (!isSignUp.value) {
                                        isSignUp.value= true
                                    } else {
                                        isSignUp.value= false
                                    }
                                }
                            } else {
                                ClickableTexts(text = "or Sign Up") {
                                    if (!isSignUp.value) {
                                        isSignUp.value= true
                                    } else {
                                        isSignUp.value= false
                                    }
                                }
                            }

                            Spacer(modifier =  Modifier.heightIn(30.dp))
                        }
                    }

                }
            }
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                TermsTexts()
            }
        }
    }
}

@Composable
fun DesignCircle (Vals: Int) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        translate(left = 00f, top = Vals.toFloat()) {
            drawCircle(Color(0xFF57CC99), radius = 350.dp.toPx())
        }
    }
}

@Composable
@Preview
fun ViewSignUpPage() {
    SignInPage()
}