package br.com.wesleyleocadio.treinamento.alunocrud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.wesleyleocadio.treinamento.alunocrud.data.local.AppDatabase
import br.com.wesleyleocadio.treinamento.alunocrud.data.repository.AlunoRepositoryImpl
import br.com.wesleyleocadio.treinamento.alunocrud.ui.theme.AlunoCRUDTheme
import br.com.wesleyleocadio.treinamento.alunocrud.view.AlunoScreen
import br.com.wesleyleocadio.treinamento.alunocrud.viewmodel.AlunoViewModel
import br.com.wesleyleocadio.treinamento.alunocrud.viewmodel.AlunoViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlunoCRUDTheme {
                val database = AppDatabase.getDatabase(this)
                val repository =
                    AlunoRepositoryImpl(
                            database.alunoDao()
                )

                val viewModel: AlunoViewModel = viewModel (
                            factory = AlunoViewModelFactory(repository)
                )

                AlunoScreen(viewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlunoCRUDTheme {
        Greeting("Android")
    }
}