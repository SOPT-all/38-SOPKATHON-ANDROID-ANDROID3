package com.sopt.android3.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.sopt.android3.BuildConfig
import com.sopt.android3.data.service.ExampleService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object ApiFactory {
    //우리 BuildConfig 방식이기 때문에 다들 로컬 (local.properties)에서 발급되는 url꽂아조야돼~!!!
    //ex) BASE_URL=https://MOCKING.com/   => 여기 URL만 바꿔끼자!
    private val BASE_URL: String = BuildConfig.BASE_URL
    private val json = Json {
        ignoreUnknownKeys = true
    }
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create(T::class.java)
}

object ServicePool {
    val exampleService = ApiFactory.create<ExampleService>()
}
