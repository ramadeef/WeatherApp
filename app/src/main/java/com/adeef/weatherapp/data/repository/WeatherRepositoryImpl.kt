package com.adeef.weatherapp.data.repository

import com.adeef.weatherapp.data.mappers.toWeatherInfo
import com.adeef.weatherapp.data.remote.WeatherApi
import com.adeef.weatherapp.domain.repository.WeatherRepository
import com.adeef.weatherapp.domain.util.Resource
import com.adeef.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}