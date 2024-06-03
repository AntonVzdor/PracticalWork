package com.example.practicalwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign.Companion.Justify
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicalwork.ui.theme.PracticalWorkTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticalWorkTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    PracticalWorkOne()
                }
            }
        }
    }
}

@Composable
fun PracticalWorkOne(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth())
        Text(
            text = stringResource(
                R.string.text_title
            ),
            fontSize = 24.sp,
            modifier = modifier
                .padding(all = 16.dp)
        )
        Text(
            text = stringResource(
                R.string.text_first
            ),
            textAlign = Justify,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = stringResource(
                R.string.text_second
            ),
            textAlign = Justify,
            modifier = modifier
                .padding(all = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PracticalWorkPreview() {
    PracticalWorkTheme {
        PracticalWorkOne()
    }
}