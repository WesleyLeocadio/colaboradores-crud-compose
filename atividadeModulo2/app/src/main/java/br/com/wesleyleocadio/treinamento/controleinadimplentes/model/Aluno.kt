package br.com.wesleyleocadio.treinamento.controleinadimplentes.model

data class Aluno(
    val id: Int,
    val nome: String,
    val telefone: String,
    val valorDevido: Double,
    val diasAtraso: Int,
    var inadimplente: Boolean)
