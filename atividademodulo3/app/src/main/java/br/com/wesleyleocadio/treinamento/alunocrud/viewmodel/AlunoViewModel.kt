package br.com.wesleyleocadio.treinamento.alunocrud.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.wesleyleocadio.treinamento.alunocrud.data.repository.AlunoRepository
import br.com.wesleyleocadio.treinamento.alunocrud.model.Aluno
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AlunoViewModel(
    private val repository: AlunoRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AlunoUiState())

    val uiState: StateFlow<AlunoUiState> = _uiState

    fun atualizarCampo(
        transformacao: (AlunoUiState) -> AlunoUiState
    ) {
        _uiState.update(transformacao)
    }

    fun iniciarEdicao(aluno: Aluno) {
        _uiState.value = AlunoUiState(
            codigo = aluno.codigo,
            nome = aluno.nome,
            nota1 = aluno.nota1.toString(),
            nota2 = aluno.nota2.toString(),
            emEdicao = true
        )
    }

    fun limparFormulario() {
        _uiState.value = AlunoUiState()
    }

    val alunos: StateFlow<List<Aluno>> =
        repository.listar.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun salvar() {

        val estado = _uiState.value

        if (
            estado.nome.isBlank() ||
            estado.nota1.isBlank() ||
            estado.nota2.isBlank()
        ) {
            return
        }

        val nota1 = estado.nota1.toDoubleOrNull() ?: 0.0
        val nota2 = estado.nota2.toDoubleOrNull() ?: 0.0

        val media = (nota1 + nota2) / 2

        val situacao =
            if (media >= 6.0)
                "Aprovado"
            else
                "Reprovado"

        viewModelScope.launch {

            val aluno = Aluno(
                codigo = estado.codigo,
                nome = estado.nome,
                nota1 = nota1,
                nota2 = nota2,
                media = media,
                situacao = situacao
            )

            if (estado.emEdicao) {
                repository.editar(aluno)
            } else {
                repository.cadastrar(aluno)
            }

            limparFormulario()
        }
    }

    fun remover(aluno: Aluno) {
        viewModelScope.launch {
            repository.remover(aluno)
        }
    }
}

