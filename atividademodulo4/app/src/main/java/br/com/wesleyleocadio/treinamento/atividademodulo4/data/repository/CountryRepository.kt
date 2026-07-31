package br.com.wesleyleocadio.treinamento.atividademodulo4.data.repository

import br.com.wesleyleocadio.treinamento.atividademodulo4.data.remote.service.CountryService
import br.com.wesleyleocadio.treinamento.atividademodulo4.model.Country

class CountryRepository(
    private val service: CountryService
) {

    suspend fun getAllCountries(): List<Country> {
        return service.getAllCountries()
    }

}
