package com.example.practicalwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.practicalwork.ui.theme.PracticalWorkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticalWorkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()){
        BusinessCard(
            image = painterResource(R.drawable._2efmo8dkgi),
            name = stringResource(R.string.text_FullName),
            title = stringResource(R.string.text_title),
            modifier = Modifier.weight(6f)
        )
        ContactsCard(
            phone = stringResource(R.string.text_PhoneNumber),
            link = stringResource(R.string.text_Link),
            email = stringResource(R.string.text_Email),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun BusinessCard(
    image: Painter,
    name: String,
    title: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
    }
}

@Composable
fun ContactsCard(
    phone: String,
    link: String,
    email: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = phone)
        Text(text = link)
        Text(text = email)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticalWorkTheme {
        BusinessCardScreen()
    }
}