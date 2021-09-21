package dev.edgaradrian.simpletextcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import dev.edgaradrian.simpletextcompose.ui.theme.SimpleTextComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalUnitApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(content = {
            GreetingText(name = "enfermeraaaaa!!!")
            //GreetingButton()
        })
    }
}

@ExperimentalUnitApi
@Composable
fun GreetingText(name: String) {
    Text(text = "Hello $name!",
        modifier = Modifier.width(240.dp)
            .height(240.dp)
            .clickable {  }
            .padding(24.dp),
        style = TextStyle(color = Color.Magenta,
        fontWeight = FontWeight.Bold,
            fontSize = TextUnit(18.0F, TextUnitType.Sp)
        )
    )
}

@ExperimentalUnitApi
@Composable
fun GreetingButton() {
    Button(onClick = {

    }) {
        GreetingText(name = "button")
    }
}

@ExperimentalUnitApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleTextComposeTheme {
        GreetingText("enfermera")
        //GreetingButton()
    }
}