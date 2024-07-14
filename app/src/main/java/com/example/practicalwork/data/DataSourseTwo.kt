package com.example.practicalwork.data

import com.example.practicalwork.R
import com.example.practicalwork.model.Courses

class DataSourseTwo {
    fun loadCourses(): List<Courses> {
        return listOf<Courses>(
            Courses(R.string.gaming, 164, R.drawable.gaming),
            Courses(R.string.drawing, 326, R.drawable.drawing),
            Courses(R.string.lifestyle, 305, R.drawable.lifestyle),
            Courses(R.string.music, 212, R.drawable.music),
            Courses(R.string.painting, 172, R.drawable.painting),
            Courses(R.string.photography, 321, R.drawable.photography),
            Courses(R.string.tech, 118, R.drawable.tech)
        )
    }
}