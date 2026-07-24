package br.com.wesleyleocadio.treinamento.alunocrud.data.local

import androidx.room.*

import kotlinx.coroutines.flow.Flow

@Dao
interface AlunoDao {

    @Query("SELECT * FROM alunos ORDER BY nome")
    fun listar(): Flow<List<AlunoEntity>>

    @Insert
    suspend fun cadastrar(aluno: AlunoEntity)

    @Update
    suspend fun editar(aluno: AlunoEntity)

    @Delete
    suspend fun remover(aluno: AlunoEntity)
}