package com.example.practicalwork.Data

data class BookList(
    val items: List<BookItem>?
)

data class BookItem(
    val id: String,
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val imageLinks: ImageLinks?
)

data class ImageLinks(
    val thumbnail: String?
)
