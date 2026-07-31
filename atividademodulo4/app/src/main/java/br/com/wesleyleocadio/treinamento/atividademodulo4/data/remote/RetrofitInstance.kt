package br.com.wesleyleocadio.treinamento.atividademodulo4.data.remote

import br.com.wesleyleocadio.treinamento.atividademodulo4.data.remote.api.CountryApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL =
        "https://countriesnow.space/api/v0.1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()

    val api: CountryApi =
        retrofit.create(CountryApi::class.java)
}
