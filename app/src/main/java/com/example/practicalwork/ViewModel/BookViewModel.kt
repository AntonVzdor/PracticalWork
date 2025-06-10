package com.example.practicalwork.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicalwork.Data.BookItem
import com.example.practicalwork.Network.ApiService
import kotlinx.coroutines.launch


class BookViewModel : ViewModel() {
    var books by mutableStateOf<List<BookItem>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun searchBook(query: String) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val response = ApiService.bookApi.searchBook(query)
                books = response.items ?: emptyList()
            } catch (e: Exception) {
                errorMessage = "Ошибка загрузки"
            } finally {
                isLoading = false
            }
        }
    }
}