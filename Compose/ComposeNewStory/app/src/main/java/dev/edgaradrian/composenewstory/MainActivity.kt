package dev.edgaradrian.composenewstory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.res.imageResource
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

    val image = imageResource(id = R.drawable.pantitlan)

    MaterialTheme {
        val typography = MaterialTheme.typography
        Column (
                modifier = Modifier.padding(16.dp)
        ){
            val imageModifier = Modifier
                    .preferredHeightIn(maxHeight = 180.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
            Image(image, modifier = imageModifier, contentScale = ContentScale.Crop)

            Text("A day in Pantitlán (entre banderas)", style = typography.h5)
            Text("México, Distrito Federal", style = typography.body1)
            Text("Agosto 2020", style = typography.body2)
        }
    }

}//NewsStory

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNewStoryTheme {
        NewsStory()
    }
}