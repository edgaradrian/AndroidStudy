package dev.edgaradrian.composenewstory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import dev.edgaradrian.composenewstory.ui.ComposeNewStoryTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory()
        }
    }
}

@Composable
fun NewsStory() {
    Column (
        modifier = Modifier.padding(16.dp)
    ){
        Text("A day in Pantitlán")
        Text("México, Distrito Federal")
        Text("Agosto 2020")
    }
}//NewsStory

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNewStoryTheme {
        NewsStory()
    }
}