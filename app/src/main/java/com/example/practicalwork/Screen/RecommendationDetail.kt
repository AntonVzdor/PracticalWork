package com.example.practicalwork.Screen

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.Data.RecommendationData
import com.example.practicalwork.Model.DataSource

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "QueryPermissionsNeeded")
fun RecommendationDetail(
    choiceRecommendation: RecommendationData,
    modifier: Modifier = Modifier
) {

    val nameForMap :String = stringResource(choiceRecommendation.recommendationName)
    val context = LocalContext.current
    val annotationText = buildAnnotatedString {
        append("Посмотрите эти места ")
        withStyle(style = SpanStyle(color = Color.Blue)){
            append("на карте")
        }
        append(" нашего города!")
    }

    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {

        val imageHeight = maxHeight * 0.3f

        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(choiceRecommendation.recommendationName),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center

                )
                Image(
                    painter = painterResource(choiceRecommendation.imageDetails),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(imageHeight)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(choiceRecommendation.description),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Justify
                )
                Text(
                    text = annotationText,
                    modifier = Modifier
                        .clickable {

                            val geoUri = Uri.parse("geo:0,0?q=${Uri.encode(nameForMap)}")
                            val intent = Intent(Intent.ACTION_VIEW, geoUri)
                            val chooser = Intent.createChooser(intent, "Выберите удобную карту")
                            context.startActivity(chooser)

                        }
                )
            }
        }
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun PreviewRecommendationDetail(){
    RecommendationDetail(
        choiceRecommendation = DataSource.recommendation.first(),

    )
}

@Preview(showBackground = true, device = "spec:width=673dp,height=841dp")
@Composable
fun PreviewRecommendationDetailMedium(){
    RecommendationDetail(
        choiceRecommendation = DataSource.recommendation.first(),

    )
}

@Preview(showBackground = true, device = "spec:width=1280dp,height=800dp,dpi=240")
@Composable
fun PreviewRecommendationDetailBig(){
    RecommendationDetail(
        choiceRecommendation = DataSource.recommendation.first(),

    )
}