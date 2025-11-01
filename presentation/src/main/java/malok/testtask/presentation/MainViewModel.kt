package malok.testtask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import malok.testtask.domain.AnimeRepository

class MainViewModel(
    private val repository: AnimeRepository
): ViewModel(){
    private val _tasks = MutableStateFlow<String>("")
    val tasks: StateFlow<String> = _tasks

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchAnimes()
    }

    fun fetchAnimes(){
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val animes = repository.loadQuote()
                if (animes.first){
                    _tasks.value = animes.second
                } else {
                    _error.value = animes.second
                }
            } catch (e: Exception){
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}