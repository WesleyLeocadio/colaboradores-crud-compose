package br.com.wesleyleocadio.treinamento.controleinadimplentes.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.wesleyleocadio.treinamento.controleinadimplentes.model.AlunoRepository
import br.com.wesleyleocadio.treinamento.controleinadimplentes.navigation.Rotas

@Composable
fun InadimplentesScreen(
    navController: NavHostController
) {

    val inadimplentes = AlunoRepository.listarInadimplentes()

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {

        items(inadimplentes) { aluno ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
                    .clickable {
                        navController.navigate(
                            "${Rotas.DETALHES_ALUNO}/${aluno.id}"
                        )
                    },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = aluno.nome,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "${aluno.diasAtraso} dias de atraso"
                    )

                    Text(
                        text = "R$ ${aluno.valorDevido}"
                    )
                }
            }
        }
    }
}