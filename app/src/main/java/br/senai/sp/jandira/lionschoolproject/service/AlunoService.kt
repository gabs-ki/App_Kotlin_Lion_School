package br.senai.sp.jandira.lionschoolproject.service

import br.senai.sp.jandira.lionschoolproject.model.Aluno
import br.senai.sp.jandira.lionschoolproject.model.AlunoLista
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlunoService {

    @GET("alunos")
    fun getAlunos(): Call<AlunoLista>

    @GET("alunos/")
    fun getAlunosPorClassAndStatus(
        @Query("curso") curso: String,
        @Query("status") status: String
    ): Call<AlunoLista>
    @GET("alunos/")
    fun getAlunosPorClass(
        @Query("curso") curso: String
    ): Call<AlunoLista>

    @GET("alunos/{matricula}")
    fun getAlunoPorMatricula(
        @Path("matricula") matricula: String
    ): Call<Aluno>


}