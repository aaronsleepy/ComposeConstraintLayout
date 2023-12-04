package song.aaron.composeconstraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import song.aaron.composeconstraintlayout.ui.theme.ComposeConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeConstraintLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
fun MainScreen() {
    ConstraintLayout(Modifier.size(width = 200.dp, height = 200.dp)) {
        val (button1, button2, button3) = createRefs()

        // Basic constraint
//        MyButton(text = "Button1", Modifier.constrainAs(button1) {
//            top.linkTo(parent.top, margin = 60.dp)
////            start.linkTo(parent.start, margin = 30.dp)
////            start.linkTo(parent.start)
////            end.linkTo(parent.end)
//            linkTo(parent.start, parent.end)
//        })

        // Opposing constraint
//        MyButton(text = "Button1", Modifier.constrainAs(button1) {
//            centerHorizontallyTo(parent)
//            top.linkTo(parent.top)
//            bottom.linkTo(button2.top)
//        })
//
//        MyButton(text = "Button2", Modifier.constrainAs(button2) {
//            centerHorizontallyTo(parent)
//            top.linkTo(button1.bottom)
//            bottom.linkTo(parent.bottom)
//        })

        // Constraint bias
        MyButton(text = "Button1", Modifier.constrainAs(button1) {
            top.linkTo(parent.top, margin = 60.dp)
            linkTo(parent.start, parent.end, bias = 0.75f)
        })
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    MainScreen()
}