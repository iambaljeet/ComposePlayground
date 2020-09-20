package com.app.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.app.composeplayground.ui.ComposePlaygroundTheme
import com.app.composeplayground.ui.teal200

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    StackElements(modifier = Modifier.fillMaxSize()
                            .background(color = Color.Gray))
                }
            }
        }
    }
}

@Composable
fun StackElements(modifier: Modifier = Modifier) {
    Stack(
            modifier = modifier
    ) {
        Box(
                shape = CircleShape,
                border = BorderStroke(width = 10.dp, color = Color.Green),
                backgroundColor = Color.Red,
                modifier = Modifier.preferredSize(200.dp)
                        .gravity(align = Alignment.Center)
        )
        Box(
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(width = 10.dp, color = Color.Yellow),
                backgroundColor = Color.Blue,
                modifier = Modifier.preferredSize(100.dp)
                        .gravity(align = Alignment.Center)
        )
        Box(
                shape = CircleShape,
                border = BorderStroke(width = 10.dp, color = Color.Blue),
                backgroundColor = Color.Magenta,
                modifier = Modifier.preferredSize(80.dp)
                        .gravity(align = Alignment.BottomCenter)
        )
    }
}

@Composable
fun VerticalElements() {
    ScrollableColumn(
        contentPadding = InnerPadding(
            start = 10.dp,
            end = 10.dp,
            top = 10.dp,
            bottom = 15.dp
        ),
        modifier = Modifier.padding(
            start = 10.dp,
            end = 25.dp,
            top = 20.dp,
            bottom = 5.dp
        )
            .background(
                color = teal200
            ).fillMaxWidth()
    ) {
        for (i in 1..50) {
            Greeting("User $i")
        }
    }
}

@Composable
fun HorizontalElements() {
    ScrollableRow() {
        for (i in 1..50) {
            Greeting("User $i")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth().clickable(onClick = {})
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlaygroundTheme {
        Greeting("Android")
    }
}