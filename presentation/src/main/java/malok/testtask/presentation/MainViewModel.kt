package malok.testtask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import malok.testtask.domain.AnimeQuoteDomain
import malok.testtask.domain.AnimeRepository

class MainViewModel(
    private val repository: AnimeRepository
): ViewModel(){
    private val _tasks = MutableStateFlow<AnimeQuoteDomain>(AnimeQuoteDomain())
    val tasks: StateFlow<AnimeQuoteDomain> = _tasks

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchAnimes()
    }

    fun fetchAnimes() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                val animes = repository.loadQuote()
                if (animes.status== "success"){
                    _tasks.value = animes
                } else {
                    _error.value = "Unexpected error exception"
                }
            } catch (e: Exception){
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}