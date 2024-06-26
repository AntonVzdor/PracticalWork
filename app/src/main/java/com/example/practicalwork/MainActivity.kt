@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.practicalwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.font.FontWeight
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
                    ClickBehaviorScreen()
                }
            }
        }
    }
}


@Composable
fun ClickBehaviorScreen(){

    var nextImage by remember { mutableIntStateOf(1) }
    var imageNext by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                Text(
                    text = "Lemonade",
                    fontWeight = FontWeight.Bold
                )
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Yellow
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding)
        ) {
            when (nextImage) {
                1 -> ClickBehavior(
                    text = stringResource(R.string.LemonTree),
                    paint = painterResource(R.drawable.lemon_tree),
                    imageClick = {
                        nextImage = 2
                        imageNext = (2..5).random()
                    }
                )

                2 -> ClickBehavior(
                    text = stringResource(R.string.Lemon),
                    paint = painterResource(R.drawable.lemon_squeeze),
                    imageClick = {
                        nextImage = 3
                    }
                )

                3 -> ClickBehavior(
                    text = stringResource(R.string.GlassOfLemonade),
                    paint = painterResource(R.drawable.lemon_drink),
                    imageClick = {
                        nextImage = 4
                    }
                )

                4 -> ClickBehavior(
                    text = stringResource(R.string.EmptyGlass),
                    paint = painterResource(R.drawable.lemon_restart),
                    imageClick = {
                        nextImage = 1
                    }
                )
            }
        }
    }
}

@Composable
fun ClickBehavior(
    paint: Painter,
    text: String,
    imageClick: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = imageClick,
            shape = RoundedCornerShape(15.dp)
        ){
        Image(painter = paint,
             contentDescription = null,
            modifier = Modifier

        )}
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticalWorkTheme {
        ClickBehaviorScreen()
    }
}