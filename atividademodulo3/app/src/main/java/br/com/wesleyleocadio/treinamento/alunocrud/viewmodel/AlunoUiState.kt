package br.com.wesleyleocadio.treinamento.alunocrud.viewmodel

data class AlunoUiState(
    val codigo: Int = 0,
    val nome: String = "",
    val nota1: String = "",
    val nota2: String = "",
    val emEdicao: Boolean = false
)

