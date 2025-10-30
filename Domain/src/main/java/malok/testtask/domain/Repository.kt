package malok.testtask.domain

interface Repository {

    suspend fun loadQuote(): Pair<Boolean, String>
}