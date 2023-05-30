package br.senai.sp.jandira.lionschoolproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolproject.ui.theme.LionSchoolProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolProjectTheme {
                // A surface container using the 'background' color from the them
                    HomeScreen()

            }
        }
    }
}

@Composable
fun HomeScreen() {

    var context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(135.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                        Box(
                            modifier = Modifier
                                .size(width = 125.dp, height = 110.dp)
                                .background(
                                    color = colorResource(id = R.color.blue_lion),
                                    shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo_lion),
                                contentDescription = "",
                                modifier = Modifier.size(width = 110.dp, height = 95.dp)
                            )
                        }

                       Row(
                           modifier = Modifier
                               .fillMaxWidth()
                               .height(105.dp)
                               .padding(start = 30.dp),
                           verticalAlignment = Alignment.CenterVertically
                       ) {
                               Box(
                                   modifier = Modifier
                                       .size(width = 3.dp, height = 70.dp)
                                       .background(color = colorResource(id = R.color.yellow_lion))
                               ) {

                               }

                               Text(
                                   text = "LION SCHOOL",
                                   modifier = Modifier.padding(start = 30.dp),
                                   color = colorResource(id = R.color.blue_lion),
                                   fontSize = 36.sp,
                                   fontWeight = FontWeight.Bold,
                                   softWrap = true,
                                   letterSpacing = 4.sp
                               )
                       }

                }

                Image(
                    painter = painterResource(id = R.drawable.team_members),
                    contentDescription = "",
                    modifier = Modifier.size(width = 252.dp, height = 242.dp)
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                        .shadow(
                            elevation = 270.dp,
                            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                            ambientColor = Color.Black,
                            spotColor = Color.Black,
                            clip = false
                        ),
                    backgroundColor = colorResource(id = R.color.blue_lion),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                    elevation = 280.dp
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            text = "Project Lion School",
                            color = colorResource(id = R.color.white),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Box(
                            modifier = Modifier
                                .size(width = 60.dp, height = 4.dp)
                                .background(color = colorResource(id = R.color.yellow_lion))
                        ) {

                        }

                        Text(
                            text = "lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                            modifier = Modifier.width(300.dp),
                            color = colorResource(id = R.color.white),
                            fontSize = 18.sp
                        )

                        Button(
                            onClick = {
                                val openHomeCursesActivity = Intent(context, HomeCursesActivity::class.java)
                                context.startActivity(openHomeCursesActivity)
                            },
                            modifier = Modifier
                                .size(width = 140.dp, height = 50.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.yellow_lion)),
                            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 10.dp, bottomStart = 10.dp, bottomEnd = 0.dp),
                            contentPadding = PaddingValues(top = 15.dp, start = 25.dp)

                        ) {
                            Text(
                                text = "Get Started",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.white),
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LionSchoolProjectTheme {
        HomeScreen()
    }
}