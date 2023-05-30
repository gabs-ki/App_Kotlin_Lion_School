package br.senai.sp.jandira.lionschoolproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolproject.ui.theme.LionSchoolProjectTheme

class ClassActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolProjectTheme {
                // A surface container using the 'background' color from the theme
                    ClassActivityScreen()

            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ClassActivityScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(width = 80.dp, height = 80.dp)
                        .background(
                            color = colorResource(id = R.color.blue_lion),
                            shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_lion),
                        contentDescription = "",
                        modifier = Modifier.size(width = 60.dp, height = 70.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(105.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 3.dp, height = 30.dp)
                            .background(color = colorResource(id = R.color.yellow_lion))
                    ) {

                    }

                    Text(
                        text = "LION SCHOOL",
                        color = colorResource(id = R.color.blue_lion),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        softWrap = true,
                        letterSpacing = 3.sp
                    )


                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .size(width = 42.dp, height = 40.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.blue_lion)),
                        contentPadding = PaddingValues(10.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.logo_lion),
                            contentDescription = ""
                        )
                    }
                }

            }

            Box(
                modifier = Modifier
                    .size(width = 210.dp, height = 50.dp)
                    .background(
                        color = colorResource(id = R.color.blue_lion),
                        shape = RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp)
                    )
            ) {
                Column(
                    Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "LISTA DE ALUNOS",
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                }
            }

            Text(
                text = "DESENVOLVIMENTO DE SISTEMAS",
                color = colorResource(id = R.color.blue_lion),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                softWrap = true,
                letterSpacing = 4.sp,
                textAlign = TextAlign.Center
            )

            Box(
                modifier = Modifier
                    .size(width = 70.dp, height = 3.dp)
                    .background(color = colorResource(id = R.color.yellow_lion))
            ) {

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(color = colorResource(id = R.color.yellow_lion))
                ) {
                    
                }
                
                Text(
                    text = "APROVADOS",
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.yellow_lion),
                    fontWeight = FontWeight.Bold
                )

                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(color = colorResource(id = R.color.blue_lion))
                ) {
                    
                }

                Text(
                    text = "CURSANDO",
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.blue_lion),
                    fontWeight = FontWeight.Bold
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {

                }
            }
        }
    }
}