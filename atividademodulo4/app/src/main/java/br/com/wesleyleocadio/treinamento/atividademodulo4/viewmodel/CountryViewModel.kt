package br.com.wesleyleocadio.treinamento.atividademodulo4.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wesleyleocadio.treinamento.atividademodulo4.data.remote.RetrofitInstance
import br.com.wesleyleocadio.treinamento.atividademodulo4.data.remote.service.CountryService
import br.com.wesleyleocadio.treinamento.atividademodulo4.data.repository.CountryRepository
import br.com.wesleyleocadio.treinamento.atividademodulo4.model.Country
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {

    private val service =
        CountryService(RetrofitInstance.api)

    private val repository =
        CountryRepository(service)

    var countries by mutableStateOf<List<Country>>(emptyList())

    var isLoading by mutableStateOf(false)

    init {
        loadCountries()
    }

    private fun loadCountries() {

        viewModelScope.launch {

            try {

                isLoading = true

                countries =
                    repository.getAllCountries()

            } finally {

                isLoading = false

            }

        }

    }

}