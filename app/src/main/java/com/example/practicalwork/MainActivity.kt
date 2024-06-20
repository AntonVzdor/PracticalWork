package com.example.practicalwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.ui.theme.PracticalWorkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticalWorkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background){
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(){

    var imageNextAndPast by remember { mutableIntStateOf(1) }

    Surface(modifier = Modifier) {
        when (imageNextAndPast) {
            1 -> ArtSpace(
                image = painterResource(R.drawable.image_1),
                title = stringResource(R.string.titleOne),
                text = stringResource(R.string.descriptionOne),
                imageClickNext = { imageNextAndPast = 2 },
                imageClickPast = { imageNextAndPast = 4 }
            )

            2 -> ArtSpace(
                image = painterResource(R.drawable.image_2),
                title = stringResource(R.string.titleTwo),
                text = stringResource(R.string.descriptionTwo),
                imageClickNext = { imageNextAndPast = 3 },
                imageClickPast = { imageNextAndPast = 1 }
            )

            3 -> ArtSpace(
                image = painterResource(R.drawable.image_3),
                title = stringResource(R.string.titleThree),
                text = stringResource(R.string.descriptionThree),
                imageClickNext = { imageNextAndPast = 4 },
                imageClickPast = { imageNextAndPast = 2 }
            )

            4 -> ArtSpace(
                image = painterResource(R.drawable.image_4),
                title = stringResource(R.string.titleFour),
                text = stringResource(R.string.descriptionFour),
                imageClickNext = { imageNextAndPast = 1 },
                imageClickPast = { imageNextAndPast = 3 }
            )
        }
    }
}

@Composable
fun ArtSpace(
    image: Painter,
    title: String,
    text: String,
    imageClickNext: () -> Unit,
    imageClickPast: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(all = 25.dp)
                .size(450.dp)
                .border(
                    BorderStroke(2.dp, Color.Gray)
                ))

        Text(text = title)

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = text)

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Button(onClick = imageClickPast) {
                Text(text = "Past")
            }
            Spacer(Modifier.width(130.0.dp))
            Button(onClick = imageClickNext) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticalWorkTheme {
        ArtSpaceScreen()
    }
}