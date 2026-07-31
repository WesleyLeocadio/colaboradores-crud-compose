package br.com.wesleyleocadio.treinamento.atividademodulo4.data.remote.api

import br.com.wesleyleocadio.treinamento.atividademodulo4.data.remote.dto.CountryResponse
import retrofit2.http.GET

interface CountryApi {

    @GET("countries/flag/images")
    suspend fun getAllCountries(): CountryResponse
}