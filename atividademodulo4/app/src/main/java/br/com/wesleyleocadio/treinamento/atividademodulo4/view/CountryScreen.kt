package br.com.wesleyleocadio.treinamento.atividademodulo4.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.wesleyleocadio.treinamento.atividademodulo4.viewmodel.CountryViewModel


@Composable
fun CountryScreen(
    viewModel: CountryViewModel = viewModel()
) {

    val countries = viewModel.countries

    Box(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
    ) {

        if (viewModel.isLoading) {

            CircularProgressIndicator(
                modifier = Modifier.align(
                    Alignment.Center
                )
            )

        } else {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize()
            ) {

                items(countries) { country ->

                    CountryCard(country)

                }

            }

        }

    }

}