package malok.animequote

import android.app.Application
import malok.testtask.data.RepositoryImpl
import malok.testtask.domain.AnimeRepository
import malok.testtask.presentation.MainViewModel
import malok.testtask.presentation.ProvideViewModel

class App: Application(), ProvideViewModel {

    private lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        val repository: AnimeRepository = RepositoryImpl()
        viewModel = MainViewModel(repository = repository)
    }

    override fun viewModel(): MainViewModel {
        return viewModel
    }

}