package com.example.practicalwork.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.practicalwork.Model.DataSource

@Composable
fun RecommendationScreen(
    rec: List<RecommendationData>,
    modifier: Modifier = Modifier,
    onClickItem: (RecommendationData) -> Unit,
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
                onClick = { onClickItem(recommendation) }
            )
        }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationScreenItem(
    onClick: () -> Unit,
    recommendation: RecommendationData,
    modifier: Modifier = Modifier
){
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
        modifier = modifier
            .padding(15.dp),
        onClick = onClick
    ){
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

@Preview
@Composable
fun PreviewRecommendationScreen(){
        RecommendationScreen(
            onClickItem = {},
            rec = DataSource.recommendation.filter { it.categoryId == 1 }
        )
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun PreviewRecommendationScreenMedium(){
    RecommendationScreen(
        onClickItem = {},
        rec = DataSource.recommendation.filter { it.categoryId == 1 }
    )
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun PreviewRecommendationScreenBig(){
    RecommendationScreen(
        onClickItem = {},
        rec = DataSource.recommendation.filter { it.categoryId == 1 }
    )
}