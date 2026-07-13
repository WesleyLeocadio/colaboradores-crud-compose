package br.com.wesleyleocadio.colaboradoresapp.ui.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.SupervisorAccount
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
            Row{
                Icon(
                    imageVector = getIconePorNivel(colaborador.nivel),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text("Nome: ${colaborador.nome}", style = MaterialTheme.typography.titleMedium)
                    Text("E-mail: ${colaborador.email}")
                    Text("Nível: ${colaborador.nivel.descricao}")
                }

            }

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

fun getIconePorNivel(nivel: Nivel) = when (nivel) {
    Nivel.SUPORTE -> Icons.Filled.Build
    Nivel.FINANCEIRO -> Icons.Filled.AttachMoney
    Nivel.ADMINISTRATIVO -> Icons.Filled.AdminPanelSettings
    Nivel.GERENCIA -> Icons.Filled.SupervisorAccount
}
