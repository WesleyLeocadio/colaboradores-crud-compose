package br.com.wesleyleocadio.treinamento.controleinadimplentes.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.wesleyleocadio.treinamento.controleinadimplentes.model.AlunoRepository

@Composable
fun EditarStatusScreen(
    navController: NavHostController,
    alunoId: Int
) {

    val aluno = AlunoRepository.buscarPorId(alunoId)

    if (aluno == null) {
        Text("Aluno não encontrado")
        return
    }

    var inadimplente by remember {
        mutableStateOf(aluno.inadimplente)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text("Aluno: ${aluno.nome}")

        Text("Status")

        Row{
            RadioButton(
                selected = !inadimplente,
                onClick = {
                    inadimplente = false
                }
            )

            Text("Em dia")
        }

        Row {
            RadioButton(
                selected = inadimplente,
                onClick = {
                    inadimplente = true
                }
            )

            Text("Inadimplente")
        }

        Button(
            onClick = {
                aluno.inadimplente = inadimplente
                navController.popBackStack()
            }
        ) {
            Text("Salvar")
        }
    }
}