package com.example.profileview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profileview.ui.theme.ProfileViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileView()
                }
            }
        }
    }
}

@Composable
fun ProfileView( modifier: Modifier = Modifier) {


    Column {

        TopView(modifier = Modifier)

        ProfileSection()

        MainView(modifier = Modifier ,  name = "Hello")
    }
}



@Composable
fun TopView( modifier: Modifier = Modifier

) {

    Row(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .background(Color(0xFF319dff))
        ,
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(60.dp)
                .padding(vertical = 10.dp)
                .padding(horizontal = 7.dp)


            ,
        )
    }

}
@Composable
fun ProfileSection(){

    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.Start
    ) {
//        Image(painter = painterResource(id = R.drawable.profileicon)
//            , contentDescription = null
//            , modifier = Modifier
//                .padding(10.dp)
//                .width(80.dp)
//                .height(80.dp)
//                .clip(RoundedCornerShape(30.dp))
//                .clickable { println("Button Clicked!") },
//
//            )
        Icon(imageVector = Icons.Outlined.Person, contentDescription =null ,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .padding(horizontal = 7.dp)
                .width(80.dp)
                .height(80.dp)
                .background(Color(0xFFebebeb), shape = RoundedCornerShape(40.dp))
                .clickable { println("Button Clicked!") },
                )
        Box(
            modifier = Modifier
                ,



        ) {
            Text(
                modifier = Modifier

                    .layout { measurable, constraints ->
                        val placeable =
                            measurable.measure(
                                // This is how wrapContent works
                                constraints.copy(minWidth = 0, minHeight = 0)
                            )
                        layout(constraints.maxWidth, constraints.maxHeight) {
                            // This is how wrapContent alignment works
                            val x = (constraints.maxWidth - placeable.width) / 18
                            val y = (constraints.maxHeight - placeable.height) / 4
                            placeable.placeRelative(x, y)
                        }
                    }
                ,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp ,
                text = "Test User"
            )
            Text(
                modifier = Modifier
                    .layout { measurable, constraints ->
                        val placeable =
                            measurable.measure(
                                // This is how wrapContent works
                                constraints.copy(minWidth = 0, minHeight = 0)
                            )
                        layout(constraints.maxWidth, constraints.maxHeight) {
                            // This is how wrapContent alignment works
                            val x = (constraints.maxWidth - placeable.width) / 10
                            val y = (constraints.maxHeight - placeable.height) / 2
                            placeable.placeRelative(x, y)
                        }
                    }
                ,
                fontWeight = FontWeight.Normal ,
                text = "testuser@investa.com"
            )
        }

        Spacer(modifier = Modifier.width(40.dp))
//        Image(painter = painterResource(id = R.drawable.notification_ring)
//            , contentDescription = null
//            , modifier = Modifier
////            .background(Color.White , shape = RoundedCornerShape(30.dp) )
//                .padding(10.dp)
//                .width(80.dp)
//                .height(80.dp)
//                .clip(RoundedCornerShape(20.dp))
//                .clickable { println("Button Clicked!") },
//
//            )
    }

}

@Composable
fun MainView( modifier: Modifier = Modifier
 , name : String) {

Column(modifier = Modifier
    .fillMaxHeight()
    .fillMaxWidth()
    .background(Color.White),
    horizontalAlignment = Alignment.Start

) {

    Spacer(modifier = Modifier
        .height(100.dp)
    )


    TabButton(name = "People")
    TabButton(name = "Legal")
    TabButton(name = "Settings")

    Divider(
        color = Color.Gray,
        modifier = Modifier
            .fillMaxWidth()
            .width(1.dp),

        )

}





}

@Composable
fun TabButton (name: String) {
    Divider(
        color = Color.Gray,
        modifier = Modifier
            .fillMaxWidth()
            .width(1.dp),

        )
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .background(Color.Transparent)
        .clickable {

        },
            verticalAlignment = Alignment.CenterVertically
        ){


            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null , modifier = Modifier.padding(3.dp))
            Text(modifier = Modifier
                .padding(5.dp)
//                .layout { measurable, constraints ->
//                    val placeable =
//                        measurable.measure(
//                            // This is how wrapContent works
//                            constraints.copy(minWidth = 0, minHeight = 0)
//                        )
//                    layout(constraints.maxWidth, constraints.maxHeight) {
//                        // This is how wrapContent alignment works
//                        val x = (constraints.maxWidth - placeable.width) / 8
//                        val y = (constraints.maxHeight - placeable.height) / 2
//                        placeable.placeRelative(x, y)
//                    }
//                }
                ,
                text = "$name",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp      ,
                textAlign = TextAlign.Left



            )


        }

}







@Preview(showBackground = true)
@Composable
fun ProfileViewPreview() {
    ProfileViewTheme {
        ProfileView()
    }
}