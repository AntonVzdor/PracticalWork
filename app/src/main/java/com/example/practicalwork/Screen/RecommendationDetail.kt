package com.example.practicalwork.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.Data.RecommendationData
import com.example.practicalwork.Model.DataSource

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun RecommendationDetail(
    choiceRecommendation: RecommendationData,
    modifier: Modifier = Modifier
) {
        Card(
            modifier = modifier
                .padding(15.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
            ) {
                Text(
                    text = stringResource(choiceRecommendation.recommendationName),
                    modifier = modifier
                        .weight(0.5f)
                )
                Image(
                    painter = painterResource(choiceRecommendation.imageDetails),
                    contentDescription = null,
                    modifier = modifier
                        .fillMaxSize()
                        .weight(0.5f)
                        .padding(vertical = 10.dp)
                )
                Text(
                    text = stringResource(choiceRecommendation.description),
                    modifier = modifier
                        .weight(1f)
                )
            }
        }
}

@Preview
@Composable
fun PreviewRecommendationDetail(){
    RecommendationDetail(
        choiceRecommendation = DataSource.recommendation.first(),

    )
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun PreviewRecommendationDetailMedium(){
    RecommendationDetail(
        choiceRecommendation = DataSource.recommendation.first(),

    )
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun PreviewRecommendationDetailBig(){
    RecommendationDetail(
        choiceRecommendation = DataSource.recommendation.first(),

    )
}