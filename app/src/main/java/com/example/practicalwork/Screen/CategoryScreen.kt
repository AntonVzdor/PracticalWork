package com.example.practicalwork.Screen

import android.annotation.SuppressLint
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
import com.example.practicalwork.Data.CategoryData
import com.example.practicalwork.Model.DataSource

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun CategoryScreen(
    onClickItem: (CategoryData) -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = contentPadding,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            items(DataSource.category) { category ->
                CategoryScreenItem(
                    onClick = { onClickItem(category) },
                    category = category,
                )
            }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreenItem(
    onClick: () -> Unit,
    category: CategoryData,
    modifier: Modifier = Modifier
){
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
        modifier = modifier
            .padding(15.dp),
        onClick = onClick
    ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxSize()
                    .size(95.dp)
            ) {
                Image(
                    painter = painterResource(category.imageId),
                    contentDescription = null,
                    Modifier.size(50.dp).padding(start = 15.dp))
                    Text(
                        text = stringResource(category.categoryName),
                        modifier = Modifier.padding(horizontal = 65.dp)
                    )
                }
            }
    }


@Preview
@Composable
fun PreviewCategory(){
    CategoryScreen(
        onClickItem = {}
    )
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun PreviewCategoryMedium(){
    CategoryScreen(
        onClickItem = {}
    )
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun PreviewCategoryBig(){
    CategoryScreen(
        onClickItem = {}
    )
}