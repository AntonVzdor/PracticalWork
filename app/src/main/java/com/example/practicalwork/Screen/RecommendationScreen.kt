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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.Data.RecommendationData
import com.example.practicalwork.Model.CoffeeRecommendationSourceList


@Composable
fun RecommendationScreen(
    rec: List<RecommendationData>,
    onClick: (RecommendationData) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(rec, key = { recommendation -> recommendation.id }){ recommendation ->
            RecommendationScreenItem(
                recommendation = recommendation,
                onItemClick = onClick
            )
        }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationScreenItem(
    recommendation: RecommendationData,
    onItemClick: (RecommendationData) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .padding(15.dp),
        onClick = {onItemClick(recommendation)}
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
                text = stringResource(recommendation.recommendationId),
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
    Column {
        Text(text = stringResource(choiceRecommendation.recommendationId))
        Image(
            painter = painterResource(choiceRecommendation.imageId),
            contentDescription = null)
        Text(text = stringResource(choiceRecommendation.descriptionId))
    }
}

@Preview
@Composable
fun PreviewRecommendationScreen(){
    RecommendationScreen(
        rec = CoffeeRecommendationSourceList.getRecommendationData(),
        onClick = {}
    )
}

@Preview
@Composable
fun PreviewRecommendationDetail(){
    RecommendationDetail(
        choiceRecommendation = choiceRecommendation
    )
}