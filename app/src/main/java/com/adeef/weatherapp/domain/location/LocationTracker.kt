package com.adeef.weatherapp.domain.location

// domain layer can not have android specific binding but for simplicity we are using
// If you use kotlin multiplatform then this will need to support ios and android this want work
import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}