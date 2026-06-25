package br.com.wesleyleocadio.colaboradoresapp.model

data class Colaborador(
    val id: Int,
    val nome: String,
    val email: String,
    val nivel: Nivel
)

