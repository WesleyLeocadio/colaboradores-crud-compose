package br.com.wesleyleocadio.treinamento.alunocrud.data.repository

import br.com.wesleyleocadio.treinamento.alunocrud.model.Aluno
import kotlinx.coroutines.flow.Flow

interface AlunoRepository {

    val listar: Flow<List<Aluno>>

    suspend fun cadastrar(aluno: Aluno)

    suspend fun editar(aluno: Aluno)

    suspend fun remover(aluno: Aluno)
}