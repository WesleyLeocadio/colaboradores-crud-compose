package br.com.wesleyleocadio.treinamento.controleinadimplentes.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.wesleyleocadio.treinamento.controleinadimplentes.navigation.NavGraph
import br.com.wesleyleocadio.treinamento.controleinadimplentes.navigation.Rotas
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjetoAcademia() {

    val navController = rememberNavController()

    // Rota Atual
    val rotaAtual = navController.currentBackStackEntryAsState().value?.destination?.route


    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text("Controle de Inadimplentes")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFF1565C0),
                            titleContentColor = Color.White
                )
            )
        },

        bottomBar = {
            NavigationBar {

                NavigationBarItem(
                    selected = rotaAtual == Rotas.HOME,
                    onClick = {
                        navController.navigate(Rotas.HOME)
                    },
                    icon = {
                        Icon(Icons.Default.Home, null)
                    },
                    label = {
                        Text("Home")
                    }
                )

                NavigationBarItem(
                    selected = rotaAtual == Rotas.INADIMPLENTES,
                    onClick = {
                        navController.navigate(Rotas.INADIMPLENTES)
                    },
                    icon = {
                        Icon(Icons.Default.Warning, null)
                    },
                    label = {
                        Text("Inadimplentes")
                    }
                )
            }
        }

    ) { padding ->

        NavGraph(
            navController = navController,
            modifier = Modifier.padding(padding)
        )
    }
}