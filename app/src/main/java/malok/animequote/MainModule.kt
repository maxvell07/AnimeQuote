package malok.animequote

import malok.testtask.data.AnimeApi
import malok.testtask.data.AnimeQuoteResponse
import malok.testtask.data.RepositoryImpl
import malok.testtask.domain.AnimeRepository
import malok.testtask.presentation.MainViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {
    // Retrofit singleton
    single {
        Retrofit.Builder()
            .baseUrl("https://api.animechan.io/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // AnimeApi from Retrofit
    single<AnimeApi> { get<Retrofit>().create(AnimeApi::class.java) }

    // Bind interface to implementation
    single<AnimeRepository> { RepositoryImpl(get()) }

    // ViewModel using new DSL
    viewModelOf(::MainViewModel)
}
