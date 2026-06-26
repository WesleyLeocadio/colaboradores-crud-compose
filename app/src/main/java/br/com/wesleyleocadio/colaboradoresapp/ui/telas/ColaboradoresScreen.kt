package br.com.wesleyleocadio.colaboradoresapp.ui.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.com.wesleyleocadio.colaboradoresapp.model.Colaborador
import br.com.wesleyleocadio.colaboradoresapp.ui.componentes.ColaboradorForm
import br.com.wesleyleocadio.colaboradoresapp.ui.componentes.ColaboradorItem
import br.com.wesleyleocadio.colaboradoresapp.viewmodel.ColaboradorViewModel

@Composable
fun ColaboradoresScreen(viewModel: ColaboradorViewModel) {

    val lista = viewModel.colaboradores

    var selecionado by remember { mutableStateOf<Colaborador?>(null) }


    Column {

        ColaboradorForm(
            colaboradorSelecionado = selecionado,
            onSalvar = { colaborador ->
                if (selecionado == null) {
                    viewModel.adicionar(colaborador)
                } else {
                    viewModel.atualizar(colaborador)
                }
                selecionado = null
            },
            onExcluir = { colaborador ->
                viewModel.remover(colaborador)
                selecionado = null
            }

        )


        LazyColumn {
            items(lista, key = { it.id }) { colaborador ->
                ColaboradorItem(colaborador,
                onSelecionar = { selecionado = it})
            }
        }
    }
}
