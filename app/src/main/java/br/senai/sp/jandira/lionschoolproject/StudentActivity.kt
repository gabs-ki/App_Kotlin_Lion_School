package br.senai.sp.jandira.lionschoolproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolproject.model.Aluno
import br.senai.sp.jandira.lionschoolproject.model.AlunoLista
import br.senai.sp.jandira.lionschoolproject.service.RetrofitFactory
import br.senai.sp.jandira.lionschoolproject.ui.theme.LionSchoolProjectTheme
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolProjectTheme {
                // A surface container using the 'background' color from the theme
                val matriculaAluno = intent.getStringExtra("matriculaAluno")

                StudentActivityScreen(

                    matriculaAluno = matriculaAluno.toString()

                )

            }
        }
    }
}


@Composable
fun StudentActivityScreen(

    matriculaAluno: String
) {

    val context = LocalContext.current

    var student by remember {
        mutableStateOf(Aluno("", "", "", ""))

    }

    var callAluno = RetrofitFactory().getAlunoService().getAlunoPorMatricula(matriculaAluno)
    callAluno.enqueue(object : Callback<Aluno>{
        override fun onResponse(
            call: Call<Aluno>,
            response: Response<Aluno>
        ) {
           if(response.isSuccessful) {
               val studentResponse = response.body()
               if (studentResponse != null) {
                   student = studentResponse
               }
           } else {
               Log.e("Deu erro", "Erro na resposta da API: ${response.code()}")
           }
        }

        override fun onFailure(
            call: Call<Aluno>,
            t: Throwable
        ) {
            Log.i("ds2t", "onFailure: ${t.message}")
        }
    })



    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
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
                            val returnClassActivity = Intent(context, ClassActivity::class.java)
                            context.startActivity(returnClassActivity)
                        },
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

                    .size(width = 320.dp ,height = 130.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = colorResource(id = R.color.blue_lion)
                        )
                ) {

                    AsyncImage(model = student.foto, contentDescription = "")

                    Text(text = student.nome)
                }

            }
            
           Column(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(50.dp),
               verticalArrangement = Arrangement.SpaceBetween,
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               Text(text = "GRÁFICO DE NOTAS")

               Box(
                   modifier = Modifier
                       .size(width = 230.dp, height = 3.dp)
                       .background(color = colorResource(id = R.color.yellow_lion))
               ) {

               }
           }

            Box(
                modifier = Modifier
                    .size(width = 340.dp, height = 230.dp)
                    .border(
                        width = 2.dp,
                        color = colorResource(id = R.color.yellow_lion),
                        shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp)
                    )
            ) {

            }
        }
    }
}