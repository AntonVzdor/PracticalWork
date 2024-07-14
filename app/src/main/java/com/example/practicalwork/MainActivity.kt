package com.example.practicalwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.practicalwork.data.DataSourseTwo
import com.example.practicalwork.data.DatasourceOne
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
    Row {
        CoursesList(
            coursesList = DatasourceOne().loadCourses(),
        )
        CoursesListTwo(
            coursesList = DataSourseTwo().loadCourses(),
        )
    }
}

@Composable
fun CoursesList(coursesList: List<Courses>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(coursesList) { courses ->
            Row {
                CoursesCardOne(
                    courses = courses,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun CoursesListTwo(coursesList: List<Courses>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(coursesList) { courses ->
                CoursesCardTwo(
                    courses = courses,
                    modifier = Modifier.padding(8.dp)
                )
        }
    }
}

@Composable
fun CoursesCardOne(
    courses: Courses, modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Row(modifier = modifier) {
            Image(
                painter = painterResource(id = courses.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .height(70.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = modifier) {
                Text(
                    text = LocalContext.current.getString(courses.stringResourceId),
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(text = "text")
            }
        }
    }
}

@Composable
fun CoursesCardTwo(
    courses: Courses, modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Row(modifier = modifier) {
            Image(
                painter = painterResource(id = courses.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .height(70.dp),
                contentScale = ContentScale.Crop
            )
                Column(modifier = modifier) {
                    Text(
                        text = LocalContext.current.getString(courses.stringResourceId),
                        modifier = Modifier.padding(10.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(text = "text")
                }
        }
    }
}


@Preview
@Composable
fun GreetingPreview() {
    PracticalWorkTheme {
        CoursesApp()
    }
}