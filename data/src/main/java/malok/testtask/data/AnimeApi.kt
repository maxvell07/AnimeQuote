package malok.testtask.data

import retrofit2.http.GET
interface AnimeApi {

    @GET("quotes/random")
    suspend fun getQuote(): AnimeQuoteResponse
}
