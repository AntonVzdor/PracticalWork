package com.example.practicalwork.Screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.Data.RecommendationData
import com.example.practicalwork.Model.DataSource

@Composable
fun RecommendationAndDetails(
    rec: List<RecommendationData>,
    modifier: Modifier = Modifier,
    choiceRecommendation: RecommendationData,
    onClickItem: (RecommendationData) -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    Row(
        modifier = modifier
    ){
        RecommendationScreen(
            rec = rec,
            onClickItem = onClickItem,
            contentPadding = PaddingValues(
                top = contentPadding.calculateTopPadding(),
            ),
            modifier = Modifier
                .weight(2f)
                .padding(horizontal = 5.dp)
                .padding(top = 125.dp)
        )

        RecommendationDetail(
            choiceRecommendation = choiceRecommendation,
            modifier = Modifier.weight(3f)
        )
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun PreviewRecommendationAndDetails(){
    RecommendationAndDetails(
        onClickItem = {},
        rec = DataSource.recommendation.filter { it.categoryId == 1 },
        choiceRecommendation = DataSource.recommendation.first(),
        contentPadding = PaddingValues()
    )
}
