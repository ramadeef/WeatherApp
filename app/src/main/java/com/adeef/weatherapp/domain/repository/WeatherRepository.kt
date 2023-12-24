package com.adeef.weatherapp.domain.repository

import com.adeef.weatherapp.domain.util.Resource
import com.adeef.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}