package com.example.practicalwork.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
fun RecommendationDetail(
    choiceRecommendation: RecommendationData,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(choiceRecommendation.recommendationName),
            modifier = modifier
                .weight(0.5f)
                .padding(top = 150.dp))
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
fun PreviewRecommendationDetail(){
    RecommendationDetail(
        choiceRecommendation = DataSource.recommendation.first(),
        contentPadding = PaddingValues()
    )
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun PreviewRecommendationDetailMedium(){
    RecommendationDetail(
        choiceRecommendation = DataSource.recommendation.first(),
        contentPadding = PaddingValues()
    )
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun PreviewRecommendationDetailBig(){
    RecommendationDetail(
        choiceRecommendation = DataSource.recommendation.first(),
        contentPadding = PaddingValues()
    )
}