package br.com.wesleyleocadio.treinamento.controleinadimplentes.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.wesleyleocadio.treinamento.controleinadimplentes.model.AlunoRepository
import br.com.wesleyleocadio.treinamento.controleinadimplentes.navigation.Rotas

@Composable
fun HomeScreen(
    navController: NavHostController
) {

    val totalAlunos = AlunoRepository.totalAlunos()

    val totalInadimplentes = AlunoRepository.totalInadimplentes()

    val valorEmAberto = AlunoRepository.valorTotalEmAberto()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        CardIndicador(
            titulo = "Total de Alunos",
            valor = totalAlunos.toString(),
            icone = Icons.Default.AccountCircle,
            cor = Color(0xFFE3F2FD)
        )

        CardIndicador(
            titulo = "Inadimplentes",
            valor = totalInadimplentes.toString(),
            icone = Icons.Default.Warning,
            cor = Color(0xFFFFF3E0),
            acao = {
                navController.navigate(Rotas.INADIMPLENTES)
            }
        )

        CardIndicador(
            titulo = "Valor em Aberto",
            valor = "R$ %.2f".format(valorEmAberto),
            icone = Icons.Default.DateRange,
            cor = Color(0xFFFFEBEE)
        )
    }
}

@Composable
fun CardIndicador(
    titulo: String,
    valor: String,
    icone: ImageVector,
    cor: Color,
    acao: (() -> Unit)? = null
) {

    Card(
        modifier = Modifier.fillMaxWidth().clickable{acao?.invoke()},
        colors = CardDefaults.cardColors(
            containerColor = cor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row {

                Icon(
                    imageVector = icone,
                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(
                    text = titulo,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Text(
                text = valor,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}