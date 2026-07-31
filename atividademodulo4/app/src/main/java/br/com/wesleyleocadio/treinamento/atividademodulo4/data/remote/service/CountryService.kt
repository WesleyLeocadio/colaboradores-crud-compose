package br.com.wesleyleocadio.treinamento.atividademodulo4.data.remote.service

import br.com.wesleyleocadio.treinamento.atividademodulo4.data.remote.api.CountryApi
import br.com.wesleyleocadio.treinamento.atividademodulo4.model.Country

class CountryService(
    private val api: CountryApi
) {

    suspend fun getAllCountries(): List<Country> {

        val response = api.getAllCountries()

        return response.data.map {

            Country(
                name = it.name,
                flag = it.flag
            )

        }
    }
}