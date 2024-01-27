package com.example.simple_signup_and_login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simple_signup_and_login.ui.theme.primaryA
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(label: String) {
    val textValue = remember{
        mutableStateOf("")
    }
    OutlinedTextField(
        value = textValue.value,
        onValueChange = { newText -> textValue.value = newText },
        maxLines = 1,
        label= { Text( text =  label) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = primaryA,
            focusedBorderColor = primaryA,
        ),
        shape = RoundedCornerShape(40),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun RoundedCornersButton (text: String, clicked: () -> Unit) {
    Button(
        onClick = clicked,
        colors = ButtonDefaults.buttonColors( containerColor = primaryA ),
        modifier = Modifier
            .height(56.dp)
            .width(276.dp)
            .background(Color.Transparent, RoundedCornerShape(2))
    ) {
        Text(
            text = text,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
    }
}

@Composable
fun SignUpText () {
    Column (modifier = Modifier.padding( horizontal =  35.dp)) {
        Text(
            text = "Welcome to", fontSize = 25.sp,
            fontWeight = FontWeight(500),
        )
        Text(
            text = "Trendify!",
            fontSize = 58.sp,
            color = primaryA,
            fontWeight = FontWeight(600),
        )
        Text(
            text = "Explore the latest stocks & track it",
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
        )
    }
}

@Composable
fun ClickableTexts(text: String, clicked: () -> Unit) {
    ClickableText(
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 150.dp),
        text = AnnotatedString(text),
        onClick = {
                  offset -> clicked()
        },
        style = TextStyle(
            fontWeight = FontWeight(500),
        )
    )
}

@Composable
fun TermsTexts() {
    Text(
        text = "Terms & Conditions apply",
        color = primaryA,
    )
}

@Composable
fun SignUpTextFields() {
    Column(modifier = Modifier.padding(horizontal = 35.dp)) {
        MyTextField(label = "Enter Name")
        Spacer(modifier =  Modifier.heightIn(20.dp))
        MyTextField(label = "Enter Email")
        Spacer(modifier =  Modifier.heightIn(20.dp))
        MyTextField(label = "Create Password")
    }
}

@Composable
fun SignInTextFields() {
    Column(modifier = Modifier.padding(horizontal = 35.dp)) {
        MyTextField(label = "Enter Name")
        Spacer(modifier =  Modifier.heightIn(20.dp))
        MyTextField(label = "Enter Password")
    }
}


@Composable
fun EclipsedBox (
    modifier: Modifier = Modifier,
    contentAlignment: Alignment,
    content: @Composable (Modifier) -> Unit
) {
    Canvas(modifier = modifier) {
        drawRoundRect(
            color = Color.Blue,
            topLeft = Offset(0f, 0f),
            size = size,
            cornerRadius = CornerRadius(5f, 5f)
        )
    }
    content(Modifier.fillMaxSize())
}


@Composable
@Preview
fun ViewComponents () {
        Surface ( modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MyTextField(label = "Name")
                RoundedCornersButton(text = "Sign Up") {}
                ClickableTexts(text = "or Login") {
                }
            }
        }
}

