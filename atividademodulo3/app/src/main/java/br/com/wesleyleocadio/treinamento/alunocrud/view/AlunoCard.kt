package br.com.wesleyleocadio.treinamento.alunocrud.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.wesleyleocadio.treinamento.alunocrud.model.Aluno

@Composable
fun AlunoCard(
    aluno: Aluno,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {

                Text(
                    text = "Código: ${aluno.codigo}",
                    style = MaterialTheme.typography.labelSmall
                )

                Text(
                    text = aluno.nome,
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = "Média: %.1f".format(aluno.media),
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    text = aluno.situacao,
                    color =
                        if (aluno.situacao == "Aprovado")
                            Color.Green
                        else
                            Color.Red
                )
            }

            Row {

                IconButton(
                    onClick = onClick
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar"
                    )
                }

                IconButton(
                    onClick = onDelete
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Excluir"
                    )
                }
            }
        }
    }
}