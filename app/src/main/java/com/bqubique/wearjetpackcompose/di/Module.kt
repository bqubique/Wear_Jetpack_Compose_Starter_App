package com.bqubique.wearjetpackcompose.di

import com.bqubique.wearjetpackcompose.api.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    private const val QURAN_BASE_URL = "https://api.quran.com"
    private const val HADITH_BASE_URL = "https://api.sunnah.com"

    val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideQuranApi(): Api {
        return Retrofit.Builder()
            .baseUrl(QURAN_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}