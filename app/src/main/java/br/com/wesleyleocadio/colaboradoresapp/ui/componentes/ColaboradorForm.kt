package br.com.wesleyleocadio.colaboradoresapp.ui.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wesleyleocadio.colaboradoresapp.model.Colaborador
import br.com.wesleyleocadio.colaboradoresapp.model.Nivel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColaboradorForm(
    onSalvar: (Colaborador) -> Unit,
    colaboradorSelecionado: Colaborador?,
    onExcluir: (Colaborador) -> Unit,
    onCancelar: () -> Unit
) {

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nivel by remember { mutableStateOf(Nivel.SUPORTE) }


    var mensagemErro by remember { mutableStateOf<String?>(null) }

    var expanded by remember { mutableStateOf(false) }


    LaunchedEffect(colaboradorSelecionado) {
        colaboradorSelecionado?.let {
            nome = it.nome
            email = it.email
            nivel = it.nivel
        } ?: run {
            nome = ""
            email = ""
            nivel = Nivel.SUPORTE
        }
    }


    Column(modifier = Modifier.safeDrawingPadding().padding(16.dp)) {

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = nivel.descricao,
                onValueChange = {},
                readOnly = true,
                label = { Text("Nível") },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                Nivel.values().forEach {
                    DropdownMenuItem(
                        text = { Text(it.descricao) },
                        onClick = {
                            nivel = it
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (colaboradorSelecionado == null) {

            Botao(
                texto = "Cadastrar",
                corFundo = MaterialTheme.colorScheme.primary,
                onClick = {

                    when {
                        nome.isBlank() -> {
                            mensagemErro = "O nome é obrigatório"
                        }
                        email.isBlank() || !email.contains("@") -> {
                            mensagemErro = "E-mail inválido"
                        }
                        else -> {
                            onSalvar(
                                Colaborador(
                                    id = System.currentTimeMillis().toInt(),
                                    nome = nome,
                                    email = email,
                                    nivel = nivel
                                )
                            )
                            nome = ""
                            email = ""
                        }
                    }

                },
                modifier = Modifier.fillMaxWidth()
            )

        } else {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Botao(
                    texto = "Alterar",
                    corFundo = MaterialTheme.colorScheme.primary,
                    onClick = {

                        when {
                            nome.isBlank() -> {
                                mensagemErro = "O nome é obrigatório"
                            }
                            email.isBlank() || !email.contains("@") -> {
                                mensagemErro = "E-mail inválido"
                            }
                            else -> {
                                onSalvar(
                                    colaboradorSelecionado.copy(
                                        nome = nome,
                                        email = email,
                                        nivel = nivel
                                    )
                                )
                                nome = ""
                                email = ""
                                nivel = Nivel.SUPORTE
                            }
                        }
                    }
                )

                Botao(
                    texto = "Excluir",
                    corFundo = MaterialTheme.colorScheme.error,
                    onClick = {
                        onExcluir(colaboradorSelecionado)
                        nome = ""
                        email = ""
                        nivel = Nivel.SUPORTE

                    },

                )

                Botao(
                    texto = "Cancelar",
                    corFundo = MaterialTheme.colorScheme.secondary,
                    onClick = {
                        nome = ""
                        email = ""
                        nivel = Nivel.SUPORTE

                        onCancelar() // 👈 AQUI
                    }
                )

            }
        }

        mensagemErro?.let {
            AlertDialog(
                onDismissRequest = { mensagemErro = null },
                confirmButton = {
                    TextButton(onClick = { mensagemErro = null }) {
                        Text("OK")
                    }
                },
                title = { Text("Atenção") },
                text = { Text(it) }
            )
        }

    }

    fun validar(): String? {
        return when {
            nome.isBlank() -> "O nome é obrigatório"
            email.isBlank() || !email.contains("@") -> "E-mail inválido"
            else -> null
        }
    }
}




