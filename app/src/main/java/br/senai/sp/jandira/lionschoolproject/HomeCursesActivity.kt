package br.senai.sp.jandira.lionschoolproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolproject.model.Curso
import br.senai.sp.jandira.lionschoolproject.model.CursoLista
import br.senai.sp.jandira.lionschoolproject.service.RetrofitFactory
import br.senai.sp.jandira.lionschoolproject.ui.theme.LionSchoolProjectTheme
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeCursesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolProjectTheme {
                    HomeCurses()
            }
        }
    }
}

@Composable
fun HomeCurses() {

    var context = LocalContext.current

    var listCursos by remember {
        mutableStateOf(listOf<Curso>())
    }

    var call = RetrofitFactory().getCursoService().getCursos()

    call.enqueue(object : Callback<CursoLista>{
        override fun onResponse(
            call: Call<CursoLista>,
            response: Response<CursoLista>
        ) {
            listCursos = response.body()!!.cursos
        }

        override fun onFailure(call: Call<CursoLista>, t: Throwable) {
            Log.i("ds2t", "onFailure: ${t.message}")
        }
    }
    )

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
                       onClick = {
                           val openMainActivity = Intent(context, MainActivity::class.java)
                           context.startActivity(openMainActivity)
                       },
                       modifier = Modifier
                           .size(width = 42.dp, height = 40.dp),
                       colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.blue_lion)),
                       contentPadding = PaddingValues(10.dp)
                   ) {
                    Icon(painter = painterResource(id = R.drawable.logo_lion), contentDescription = "")
                   }
               }

           }

            Box(
                modifier = Modifier
                    .size(width = 290.dp, height = 80.dp)
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
                        text = "Gerencimento De Curso",
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Para prosseguir selecione um curso...",
                        color = colorResource(id = R.color.white),
                        softWrap = true,
                        modifier = Modifier.width(160.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light
                    )
                }
            }

            Image(
                painter = painterResource(
                    id = R.drawable.idea_image),
                contentDescription = "",
                modifier = Modifier.size( width =  130.dp, height =  130.dp)
            )

            Text(
                text = "SELECIONE UM CURSO",
                color = colorResource(id = R.color.blue_lion),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 4.sp,
                modifier = Modifier.padding(start = 20.dp)
            )

            Box(
                modifier = Modifier
                    .size(width = 200.dp, height = 3.dp)
                    .background(color = colorResource(id = R.color.yellow_lion))

            ) {

            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(start = 50.dp),
                horizontalAlignment = Alignment.End

            ) {
                items(listCursos) {
                    Card(
                        modifier = Modifier
                            .size(width = 350.dp, height = 85.dp)
                            .padding(vertical = 7.dp)
                            .clickable(enabled = true) {
                                val openStudent = Intent(context, ClassActivity::class.java)
                                openStudent.putExtra("sigla", it.sigla)
                                openStudent.putExtra("nome", it.nome)
                                context.startActivity(openStudent)
                            },
                        backgroundColor = colorResource(id = R.color.blue_lion),
                        shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)

                    ) {
                        Row(
                            modifier = Modifier
                            .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {

                            AsyncImage(
                                model = it.icone,
                                contentDescription = "Curso Icone",
                                colorFilter = ColorFilter.tint(color = colorResource(id = R.color.white)),
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(start = 10.dp)
                            )

                            Text(
                                text = it.sigla,
                                color = colorResource(id = R.color.white),
                                modifier = Modifier.padding(start = 20.dp)
                            )

                            Text(
                                text = it.nome,
                                color = colorResource(id = R.color.white),
                                modifier = Modifier.padding(start = 20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    LionSchoolProjectTheme {
        HomeCurses()
    }
}