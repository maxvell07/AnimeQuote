package malok.testtask.data

data class AnimeQuoteResponse(
    val status: String,
    val data: QuoteData
)

data class QuoteData(
    val content: String,
    val anime: AnimeInfo,
    val character: CharacterInfo
)

data class AnimeInfo(
    val id: Int,
    val name: String,
    val altName: String
)

data class CharacterInfo(
    val id: Int,
    val name: String
)
