package com.example.practicalwork.data

import com.example.practicalwork.R
import com.example.practicalwork.model.Courses


class DatasourceOne {
    fun loadCourses(): List<Courses> {
        return listOf<Courses>(
            Courses(R.string.architecture, 58, R.drawable.architecture),
            Courses(R.string.crafts, 121, R.drawable.crafts),
            Courses(R.string.business, 78, R.drawable.business),
            Courses(R.string.culinary, 118, R.drawable.culinary),
            Courses(R.string.design, 423, R.drawable.design),
            Courses(R.string.fashion, 92, R.drawable.fashion),
            Courses(R.string.film, 165, R.drawable.film),

        )
    }
}
