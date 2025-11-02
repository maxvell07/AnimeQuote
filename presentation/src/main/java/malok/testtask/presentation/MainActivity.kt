package malok.testtask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import malok.testtask.presentation.ui.theme.AnimeQuoteTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: MainViewModel by viewModel()
        setContent {
            AnimeQuoteTheme {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}
