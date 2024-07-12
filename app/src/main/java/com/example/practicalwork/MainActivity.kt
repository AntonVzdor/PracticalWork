package com.example.practicalwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicalwork.data.Datasource
import com.example.practicalwork.model.Courses
import com.example.practicalwork.ui.theme.PracticalWorkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticalWorkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background){
                    CoursesApp()
                }
            }
        }
    }
}

@Composable
fun CoursesApp() {
    CoursesList(
        coursesList = Datasource().loadCourses(),
    )
}

@Composable
fun CoursesList(coursesList: List<Courses>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(coursesList) { courses ->
            CoursesCard(
                courses = courses,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun CoursesCard(
    courses: Courses, modifier: Modifier = Modifier
){
    Card(modifier = modifier) {
        Column {
Image(painter = painterResource(id = courses.imageResourceId),
    contentDescription = null,
    modifier = Modifier
        .fillMaxWidth()
        .height(194.dp),
    contentScale = ContentScale.Crop)
            Text(
                text = LocalContext.current.getString(courses.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
}
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticalWorkTheme {
        CoursesApp()
    }
}