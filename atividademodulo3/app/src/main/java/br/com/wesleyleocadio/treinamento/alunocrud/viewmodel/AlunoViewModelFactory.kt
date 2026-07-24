package br.com.wesleyleocadio.treinamento.alunocrud.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.wesleyleocadio.treinamento.alunocrud.data.repository.AlunoRepository

class AlunoViewModelFactory(
    private val repository: AlunoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(AlunoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AlunoViewModel(repository) as T
        }

        throw IllegalArgumentException("Falha ao disponibilizar o repository")
    }
}