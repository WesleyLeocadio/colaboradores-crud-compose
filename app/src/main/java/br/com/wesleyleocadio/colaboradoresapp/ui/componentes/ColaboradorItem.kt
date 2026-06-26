package br.com.wesleyleocadio.colaboradoresapp.ui.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wesleyleocadio.colaboradoresapp.model.Colaborador
import br.com.wesleyleocadio.colaboradoresapp.model.Nivel

@Composable
fun ColaboradorItem(colaborador: Colaborador, onSelecionar: (Colaborador) -> Unit) {

    val cor = when(colaborador.nivel) {
        Nivel.SUPORTE -> MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
        Nivel.FINANCEIRO -> MaterialTheme.colorScheme.tertiary.copy(alpha = 0.1f)
        Nivel.ADMINISTRATIVO -> MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f)
        Nivel.GERENCIA -> MaterialTheme.colorScheme.error.copy(alpha = 0.1f)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = cor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

        ) {

            Text("Nome: ${colaborador.nome}", style = MaterialTheme.typography.titleMedium)
            Text("E-mail: ${colaborador.email}")
            Text("Nível: ${colaborador.nivel.descricao}")

            Spacer(modifier = Modifier.height(8.dp))

            Botao(
                texto = "Selecionar",
                corFundo = MaterialTheme.colorScheme.primary,
                onClick = {onSelecionar(colaborador)},
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

        }
    }
}
