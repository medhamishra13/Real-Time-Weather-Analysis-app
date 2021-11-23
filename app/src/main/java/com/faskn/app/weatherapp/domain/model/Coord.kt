package com.faskn.app.weatherapp.domain.model

import android.os.Parcelable
import androidx.room.Ignore
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Coord(

    @Json(name = "lon")
    val lon: Double?,

    @Json(name = "lat")
    val lat: Double?
) : Parcelable
{

        @Ignore
        constructor(long: Double,lati: Double):this(
        lat=lati,
            lon=long
        ) }


