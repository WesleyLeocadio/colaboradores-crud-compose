package br.com.wesleyleocadio.treinamento.alunocrud.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wesleyleocadio.treinamento.alunocrud.viewmodel.AlunoViewModel


@Composable
fun AlunoScreen(viewModel: AlunoViewModel) {

    val listaAlunos by viewModel.alunos.collectAsState()

    val uiState by viewModel.uiState.collectAsState()

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text =
                if (uiState.emEdicao)
                    "Editar Aluno"
                else
                    "Cadastrar Aluno",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.nome,
            onValueChange = { valor ->
                viewModel.atualizarCampo {
                    it.copy(nome = valor)
                }
            },
            label = {
                Text("Nome")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = uiState.nota1,
            onValueChange = { valor ->
                viewModel.atualizarCampo {
                    it.copy(nota1 = valor)
                }
            },
            label = {
                Text("Nota 1")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = uiState.nota2,
            onValueChange = { valor ->
                viewModel.atualizarCampo {
                    it.copy(nota2 = valor)
                }
            },
            label = {
                Text("Nota 2")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row {

            Button(
                onClick = {
                    viewModel.salvar()
                    focusManager.clearFocus()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    if (uiState.emEdicao)
                        "Editar"
                    else
                        "Cadastrar"
                )
            }

            if (uiState.emEdicao) {

                Spacer(modifier = Modifier.width(8.dp))

                OutlinedButton(
                    onClick = {
                        viewModel.limparFormulario()
                        focusManager.clearFocus()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Cancelar")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn {

            items(listaAlunos) { aluno ->

                AlunoCard(
                    aluno = aluno,
                    onClick = {
                        viewModel.iniciarEdicao(aluno)
                        focusManager.clearFocus()
                    },
                    onDelete = {
                        viewModel.remover(aluno)
                        focusManager.clearFocus()
                    }
                )
            }
        }
    }
}