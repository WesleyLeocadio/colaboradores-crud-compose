package br.com.wesleyleocadio.treinamento.atividademodulo4.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wesleyleocadio.treinamento.atividademodulo4.model.Country
import coil.compose.AsyncImage

@Composable
fun CountryCard(country: Country) {

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),

            verticalArrangement = Arrangement.Center,

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = country.flag,
                contentDescription = country.name,
                modifier = Modifier.size(100.dp)
            )

            Text(country.name)

        }

    }

}