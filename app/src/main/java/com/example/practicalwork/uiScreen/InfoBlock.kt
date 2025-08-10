package com.example.practicalwork.uiScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.R

@Composable
fun InfoBlock(
    departTitle: String,
    departName: String,
    arriveTitle: String,
    arriveName: String,
) {
    Box(
        modifier = Modifier
            .padding(all = 10.dp)
            .background(
                color = colorResource(
                    R.color.teal_200
                )
            )
    ) {

        Row(
            modifier = Modifier
                .padding(all = 7.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(text = "DEPART")
                Spacer(modifier = Modifier.padding(3.dp))
                Row {
                    Text(text = departTitle)
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(text = departName)
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "ARRIVE")
                Spacer(modifier = Modifier.padding(3.dp))
                Row {
                    Text(text = arriveTitle)
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(text = arriveName)
                }
            }
            Spacer(modifier = Modifier.padding(65.dp))
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "no"

            )
        }
    }
}

@Preview
@Composable
fun PreviewInfoBlock(){
    InfoBlock(
        "FCO",
        "leofca",
        "MUS",
        "Sheretetet"
    )
}