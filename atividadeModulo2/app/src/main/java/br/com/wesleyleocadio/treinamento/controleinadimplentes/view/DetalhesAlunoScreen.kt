package br.com.wesleyleocadio.treinamento.controleinadimplentes.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun DetalhesAlunoScreen(
    navController: NavHostController,
    alunoId: Int
) {
    Text("Detalhes do aluno: $alunoId")
}