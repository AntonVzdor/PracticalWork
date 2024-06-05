package com.example.practicalwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.ui.theme.PracticalWorkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticalWorkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantScreen()
                }
            }
            }
        }
    }


@Composable
fun ComposeQuadrantScreen() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposeQuadrant(
                title = stringResource(R.string.text_title_one),
                text = stringResource(R.string.text_one),
                color = colorResource(R.color.color_one),
                modifier = Modifier.weight(1f)
            )
            ComposeQuadrant(
                title = stringResource(R.string.text_title_two),
                text = stringResource(R.string.text_two),
                color = colorResource(R.color.color_two),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposeQuadrant(
                title = stringResource(R.string.text_title_three),
                text = stringResource(R.string.text_three),
                color = colorResource(R.color.color_three),
                modifier = Modifier.weight(1f)
            )
            ComposeQuadrant(
                title = stringResource(R.string.text_title_four),
                text = stringResource(R.string.text_four),
                color = colorResource(R.color.color_four),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposeQuadrant(
    title : String,
    text : String,
    color: Color,
    modifier: Modifier = Modifier
){
            Column(
                modifier = modifier
                    .background(color)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = title,
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = text,
                    textAlign = TextAlign.Justify
                )

            }
        }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticalWorkTheme {
        ComposeQuadrantScreen()
    }
}