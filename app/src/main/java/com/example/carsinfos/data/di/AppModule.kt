package com.example.carsinfos.data.di

import com.example.carsinfos.common.Constants
import com.example.carsinfos.data.CarApi
import com.example.carsinfos.data.repository.CarRepositoryImpl
import com.example.carsinfos.domain.repository.CarRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCarRepository( api : CarApi) : CarRepository {
        return CarRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCarApi() : CarApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CarApi::class.java)
    }
}