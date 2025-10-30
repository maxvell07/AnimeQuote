package malok.testtask.data

import com.sun.tools.javac.util.Pair
import malok.testtask.domain.AnimeRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryImpl(
   val api: AnimeApi
): AnimeRepository {
    constructor(): this(
        Retrofit.Builder().baseUrl("https://api.animechan.io/v1/").addConverterFactory(
            GsonConverterFactory.create()).build().create(AnimeApi::class.java)
    )

    override suspend fun loadQuote(): Pair<Boolean, String> {
       return try {
           val quote = api.getQuote()
           Pair(true, quote.data.content)
       } catch (e: Exception) {
           Pair.of(false, e.message ?: "Unknown error")
       }

    }
}