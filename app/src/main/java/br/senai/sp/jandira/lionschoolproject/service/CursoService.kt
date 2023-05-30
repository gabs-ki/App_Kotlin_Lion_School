package br.senai.sp.jandira.lionschoolproject.service

import br.senai.sp.jandira.lionschoolproject.model.Curso
import br.senai.sp.jandira.lionschoolproject.model.CursoLista
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CursoService {

    //https://jolly-fox-jacket.cyclic.app/v1/lion-school/
    
    @GET("cursos")
    fun getCursos(): Call<CursoLista>

}