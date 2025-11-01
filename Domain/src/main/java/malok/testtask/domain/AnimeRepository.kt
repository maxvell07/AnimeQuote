package malok.testtask.domain

import com.sun.tools.javac.util.Pair

interface AnimeRepository {

    suspend fun loadQuote(): kotlin.Pair<Boolean, String>
}