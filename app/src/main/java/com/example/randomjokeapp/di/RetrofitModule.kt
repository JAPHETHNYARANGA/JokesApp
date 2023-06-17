package com.example.randomjokeapp.di

import com.example.randomjokeapp.data.network.RetrofitInterface
import com.example.randomjokeapp.data.repositories.GetJokeRepository
import com.example.randomjokeapp.domain.useCases.GetJokesUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val BASE_URL = "https://official-joke-api.appspot.com/"

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideRetrofitInterface(retrofit: Retrofit):RetrofitInterface{
        return retrofit.create(RetrofitInterface::class.java)
    }

    @Provides
    fun provideJokesRepository(retrofitInterface: RetrofitInterface):GetJokeRepository{
        return GetJokeRepository(retrofitInterface)
    }

    @Provides
    fun provideJokesUseCase(getJokeRepository: GetJokeRepository):GetJokesUseCase{
        return GetJokesUseCase(getJokeRepository)
    }
}