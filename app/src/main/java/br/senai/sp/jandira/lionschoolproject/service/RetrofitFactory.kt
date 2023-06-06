package br.senai.sp.jandira.lionschoolproject.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitFactory {
    private val BASE_URL = "https://jolly-fox-jacket.cyclic.app/v1/lion-school/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCursoService(): CursoService {
        return retrofitFactory.create(CursoService::class.java)
    }

    fun getAlunoService(): AlunoService {
        return  retrofitFactory.create(AlunoService::class.java)
    }
}