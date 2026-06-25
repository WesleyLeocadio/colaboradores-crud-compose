package br.com.wesleyleocadio.colaboradoresapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import br.com.wesleyleocadio.colaboradoresapp.model.Colaborador


class ColaboradorViewModel : ViewModel() {

    val colaboradores = mutableStateListOf<Colaborador>()

    fun adicionar(colaborador: Colaborador) {
        colaboradores.add(colaborador)
    }

    fun remover(colaborador: Colaborador) {
        colaboradores.remove(colaborador)
    }

    fun atualizar(colaboradorAtualizado: Colaborador) {
        val index = colaboradores.indexOfFirst { it.id == colaboradorAtualizado.id }
        if (index != -1) {
            colaboradores[index] = colaboradorAtualizado
        }
    }
}
