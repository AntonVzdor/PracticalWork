package com.example.practicalwork.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
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
fun RecommendationScreen(
    rec: List<RecommendationData>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(rec, key = { recommendation -> recommendation }){ recommendation ->
            RecommendationScreenItem(
                recommendation = recommendation,
            )
        }
        }
    }

@Composable
fun RecommendationScreenItem(
    recommendation: RecommendationData,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .padding(15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxSize()
                .size(95.dp)
        ) {
            Image(
                painter = painterResource(recommendation.imageId),
                contentDescription = null)
            Text(
                text = stringResource(recommendation.recommendationName),
                modifier = Modifier.padding(horizontal = 65.dp)
            )
        }
    }
}

@Composable
fun RecommendationDetail(
    choiceRecommendation: RecommendationData,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(choiceRecommendation.recommendationName),
            modifier = modifier.weight(0.5f).padding(top = 150.dp))
        Image(
            painter = painterResource(choiceRecommendation.imageId),
            contentDescription = null,
            modifier = modifier.weight(1f))
        Text(
            text = stringResource(choiceRecommendation.description),
            modifier = modifier.weight(1f))
    }
}

@Preview
@Composable
fun PreviewRecommendationScreen(){
    RecommendationScreen(
        rec = DataSource.recommendation
    )
}

@Preview
@Composable
fun PreviewRecommendationDetail(){
    RecommendationDetail(
        choiceRecommendation = DataSource.recommendation.first()
    )
}