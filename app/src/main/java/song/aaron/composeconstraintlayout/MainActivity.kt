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
import androidx.constraintlayout.compose.ChainStyle
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
//    ConstraintLayout(Modifier.size(width = 200.dp, height = 200.dp)) {
//        val (button1, button2, button3) = createRefs()
//
//        // Basic constraint
////        MyButton(text = "Button1", Modifier.constrainAs(button1) {
////            top.linkTo(parent.top, margin = 60.dp)
//////            start.linkTo(parent.start, margin = 30.dp)
//////            start.linkTo(parent.start)
//////            end.linkTo(parent.end)
////            linkTo(parent.start, parent.end)
////        })
//
//        // Opposing constraint
////        MyButton(text = "Button1", Modifier.constrainAs(button1) {
////            centerHorizontallyTo(parent)
////            top.linkTo(parent.top)
////            bottom.linkTo(button2.top)
////        })
////
////        MyButton(text = "Button2", Modifier.constrainAs(button2) {
////            centerHorizontallyTo(parent)
////            top.linkTo(button1.bottom)
////            bottom.linkTo(parent.bottom)
////        })
//
//        // Constraint bias
////        MyButton(text = "Button1", Modifier.constrainAs(button1) {
////            top.linkTo(parent.top, margin = 60.dp)
////            linkTo(parent.start, parent.end, bias = 0.75f)
////        })
//
//        // Constraint chain
////        createHorizontalChain(button1, button2, button3, chainStyle = ChainStyle.SpreadInside)
////
////        MyButton(text = "Button1", Modifier.constrainAs(button1) {
////            centerVerticallyTo(parent)
////        })
////        MyButton(text = "Button2", Modifier.constrainAs(button2) {
////            centerVerticallyTo(parent)
////        })
////        MyButton(text = "Button3", Modifier.constrainAs(button3) {
////            centerVerticallyTo(parent)
////        })
//    }

    // Guideline
    ConstraintLayout(Modifier.size(width = 400.dp, height=220.dp)) {
        val (button1, button2, button3) = createRefs()

        val guide = createGuidelineFromStart(fraction = .60f)

        MyButton(text = "Button1", Modifier.constrainAs(button1) {
            top.linkTo(parent.top, margin=30.dp)
            end.linkTo(guide, margin = 30.dp)
        })

        MyButton(text = "Button2", Modifier.constrainAs(button2) {
            top.linkTo(button1.bottom, margin=20.dp)
            start.linkTo(guide, margin = 40.dp)
        })

        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            top.linkTo(button2.bottom, margin=40.dp)
            end.linkTo(guide, margin = 20.dp)
        })
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    MainScreen()
}