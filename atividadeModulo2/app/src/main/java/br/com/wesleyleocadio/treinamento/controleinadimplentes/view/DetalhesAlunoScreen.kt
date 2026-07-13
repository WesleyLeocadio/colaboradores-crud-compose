package br.com.wesleyleocadio.treinamento.controleinadimplentes.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.wesleyleocadio.treinamento.controleinadimplentes.model.AlunoRepository
import br.com.wesleyleocadio.treinamento.controleinadimplentes.navigation.Rotas

@Composable
fun DetalhesAlunoScreen(
    navController: NavHostController,
    alunoId: Int
) {

    val aluno = AlunoRepository.buscarPorId(alunoId)

    if (aluno == null) {
        Text("Aluno não encontrado")
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = aluno.nome,
                    style = MaterialTheme.typography.headlineSmall
                )

                Text("Telefone: ${aluno.telefone}")

                Text(
                    text = "Valor devido: R$ ${aluno.valorDevido}"
                )

                Text(
                    text = "Dias de atraso: ${aluno.diasAtraso}"
                )

                Text(
                    text = if (aluno.inadimplente)
                        "Status: Inadimplente"
                    else
                        "Status: Em dia"
                )
            }
        }

        Button(
            onClick = {
                navController.navigate(
                    "${Rotas.EDITAR_STATUS}/$alunoId"
                )
            }
        ) {
            Text("Editar Status")
        }

        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("Voltar")
        }
    }
}