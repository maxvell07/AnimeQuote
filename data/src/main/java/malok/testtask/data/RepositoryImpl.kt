package malok.testtask.data

import malok.testtask.domain.AnimeRepository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
   val api: AnimeApi
): AnimeRepository {

    override suspend fun loadQuote(): Pair<Boolean, String> {
       return try {
           val quote = api.getQuote()
           Pair(true, quote.data.content)
       } catch (e: Exception) {
           Pair(false, e.message ?: "Unknown error")
       }

    }
}