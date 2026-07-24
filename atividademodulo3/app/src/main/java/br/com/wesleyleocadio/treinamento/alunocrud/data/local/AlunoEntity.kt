package br.com.wesleyleocadio.treinamento.alunocrud.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alunos")
data class AlunoEntity(

    @PrimaryKey(autoGenerate = true)
    val codigo: Int = 0,

    val nome: String,
    val nota1: Double,
    val nota2: Double,
    val media: Double,
    val situacao: String
)