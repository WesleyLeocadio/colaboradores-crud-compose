package br.com.wesleyleocadio.treinamento.atividademodulo4.data.remote.dto

data class CountryResponse(
    val error: Boolean,
    val msg: String,
    val data: List<CountryDto>
)