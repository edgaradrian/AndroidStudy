package dev.edgaradrian.simpletextcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.edgaradrian.simpletextcompose.ui.theme.SimpleTextComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(content = {
            //GreetingText(name = "enfermeraaaaa!!!")
            GreetingButton()
        })
    }
}

@Composable
fun GreetingText(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun GreetingButton() {
    Button(onClick = {

    }) {
        GreetingText(name = "button")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleTextComposeTheme {
        //GreetingText("Android")
        GreetingButton()
    }
}