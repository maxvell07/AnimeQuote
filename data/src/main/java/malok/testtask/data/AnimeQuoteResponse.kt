package malok.testtask.data

import malok.testtask.domain.AnimeQuoteDomain

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

fun AnimeQuoteResponse.map(): AnimeQuoteDomain {
    return AnimeQuoteDomain(
        status = status,
        quote = data.content,
        anime = data.anime.name+"(${data.anime.altName})",
        characterName = data.character.name
    )
}