package malok.testtask.data

import malok.testtask.domain.AnimeQuoteDomain
import malok.testtask.domain.AnimeRepository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
   val api: AnimeApi
): AnimeRepository {
    override suspend fun loadQuote(): AnimeQuoteDomain {
        return  api.getQuote().map()
    }
}