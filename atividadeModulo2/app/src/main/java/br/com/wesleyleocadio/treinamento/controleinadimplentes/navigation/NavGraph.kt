package br.com.wesleyleocadio.treinamento.controleinadimplentes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.wesleyleocadio.treinamento.controleinadimplentes.view.DetalhesAlunoScreen
import br.com.wesleyleocadio.treinamento.controleinadimplentes.view.EditarStatusScreen
import br.com.wesleyleocadio.treinamento.controleinadimplentes.view.HomeScreen
import br.com.wesleyleocadio.treinamento.controleinadimplentes.view.InadimplentesScreen


@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = Rotas.HOME,
        modifier = modifier
    ) {

        composable(
            route = Rotas.HOME
        ) {
            HomeScreen(
                navController = navController
            )
        }

        composable(
            route = Rotas.INADIMPLENTES
        ) {
            InadimplentesScreen(
                navController = navController
            )
        }

        composable(
            route = "${Rotas.DETALHES_ALUNO}/{id}"
        ) { backStackEntry ->

            val alunoId = backStackEntry
                .arguments
                ?.getString("id")
                ?.toIntOrNull() ?: 0

            DetalhesAlunoScreen(
                navController = navController,
                alunoId = alunoId
            )
        }

        composable(
            route = "${Rotas.EDITAR_STATUS}/{id}"
        ) { backStackEntry ->

            val alunoId = backStackEntry
                .arguments
                ?.getString("id")
                ?.toIntOrNull() ?: 0

            EditarStatusScreen(
                navController = navController,
                alunoId = alunoId
            )
        }
    }
}