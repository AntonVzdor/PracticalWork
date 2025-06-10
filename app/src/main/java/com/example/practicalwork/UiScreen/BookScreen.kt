package com.example.practicalwork.UiScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.practicalwork.ViewModel.BookViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import com.example.practicalwork.R

@Composable
fun BookCoverGrid(viewModel: BookViewModel = viewModel()) {
    val books = viewModel.books
    val isLoading = viewModel.isLoading
    val errorMessage = viewModel.errorMessage

    var query by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(10.dp)) {

        CenterTopBar()

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Поиск книг") },
            modifier = Modifier.fillMaxWidth(),

        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { viewModel.searchBook(query) }) {
            Text("Поиск")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator()
        }

        errorMessage?.let {
            Text("Ошибка: $it", color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 120.dp),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(books) { book ->
                val thumbnail = book.volumeInfo.imageLinks?.thumbnail
                if (thumbnail != null) {
                    AsyncImage(
                        model = thumbnail.replace("http://", "https://"),
                        placeholder = painterResource(R.drawable.ic_broken_image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(0.7f)
                    )
                }
            }
        }
    }
}