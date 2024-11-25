package com.example.practicalwork.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.practicalwork.Data.CategoryData

@Composable
fun CategoryScreen(
    category: List<CategoryData>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues =PaddingValues(0.dp)
){
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        items( category, key = {category -> category.id} ){ category ->
            CategoryScreenItem(
                category = category,
                onItemClick = onClick
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreenItem(
    category: CategoryData,
    onItemClick: (CategoryData) -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
    ) {
        Column(

        ) {
            Row(

            ) {
                Image(
                    painter = painterResource(category.imageId),
                    contentDescription = null)
                Text(text = stringResource(category.categoryId))
            }
        }
    }
}