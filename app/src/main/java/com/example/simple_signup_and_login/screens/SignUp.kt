package com.example.simple_signup_and_login.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.simple_signup_and_login.components.ClickableTexts
import com.example.simple_signup_and_login.components.EclipsedBox
import com.example.simple_signup_and_login.components.MyTextField
import com.example.simple_signup_and_login.components.RoundedCornersButton
import com.example.simple_signup_and_login.components.SignUpText
import com.example.simple_signup_and_login.components.SignUpTextFields
import com.example.simple_signup_and_login.components.SignupDesignCircle
import com.example.simple_signup_and_login.components.TermsTexts
import com.example.simple_signup_and_login.ui.theme.primaryA

@Composable
fun SignUp (navController: NavHostController?=null) {
    Surface (
        modifier = Modifier
        .fillMaxSize(),
        color = Color(0xFF80ED99)
    ) {
        SignupDesignCircle()
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier =  Modifier.heightIn(40.dp))
            SignUpText()
            Spacer(modifier =  Modifier.heightIn(40.dp))
            SignUpTextFields()
            Spacer(modifier =  Modifier.heightIn(40.dp))
            Box (
                modifier = Modifier.fillMaxSize(),
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 50.dp,)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    RoundedCornersButton(text = "Sign Up") {}
                    ClickableTexts(text = "or Login",){
                        navController?.navigate("Sign In")
                    }
                    Box (
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        TermsTexts()
                    }
                }
            }

        }
    }
}



@Composable
@Preview
fun ShowPage () {
    SignUp()
}