package com.faskn.app.weatherapp.domain.model

import android.os.Parcelable
import androidx.room.Ignore
import com.faskn.app.weatherapp.db.entity.CoordEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class City(

    @Json(name = "country")
    val country: String?,

    @Json(name = "coord")
    val coord: Coord?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "id")
    val id: Int?
) : Parcelable
{
    @Ignore
    constructor(id:Int, coord: Coord, city:String, country: String):this(
        id = id,
        coord = coord?.let { Coord(coord.lon,coord.lat) },
        name = city,
        country = country
    )
}
