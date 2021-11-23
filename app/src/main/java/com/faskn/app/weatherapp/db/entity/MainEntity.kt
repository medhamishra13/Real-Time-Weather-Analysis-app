package com.faskn.app.weatherapp.db.entity

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import com.faskn.app.weatherapp.domain.model.Main
import androidx.appcompat.app.AppCompatActivity
import kotlinx.parcelize.Parcelize
import android.view.View
import android.view.ViewGroup


@Parcelize
@Entity(tableName = "Main")
data class MainEntity(
    @ColumnInfo(name = "temp")
    var temp: Double?,
    @ColumnInfo(name = "tempMin")
    var tempMin: Double?,
    @ColumnInfo(name = "grndLevel")
    var grndLevel: Double?,
    @ColumnInfo(name = "tempKf")
    var tempKf: Double?,
    @ColumnInfo(name = "humidity")
    var humidity: Int?,
    @ColumnInfo(name = "pressure")
    var pressure: Double?,
    @ColumnInfo(name = "seaLevel")
    var seaLevel: Double?,
    @ColumnInfo(name = "tempMax")
    var tempMax: Double?
) : Parcelable {
    @Ignore
    constructor(main: Main?) : this(
        temp = main?.temp,
        tempMin = main?.tempMin,
        grndLevel = main?.grndLevel,
        tempKf = main?.tempKf,
        humidity = main?.humidity,
        pressure = main?.pressure,
        seaLevel = main?.seaLevel,
        tempMax = main?.tempMax
    )

    fun getTempString(): String {

        return temp.toString().substringBefore(".") + "°C"
    }

    fun getHumidityString(): String {
        return "Humidity: "+humidity.toString() + "%"
    }
    fun getTempMinString(): String {
        return "Min temp: "+tempMin.toString().substringBefore(".") + "°C"
    }

    fun getTempMaxString(): String {
        return "Max temp: "+tempMax.toString().substringBefore(".") + "°C"
    }
   fun getPressureString(): String {
        return "Pressure: "+pressure.toString().substringBefore(".")+ "hPa"
    }
    fun getColor1():GradientDrawable{
        if(temp.toString().substringBefore(".").toFloat()>=30.0)
        {val gradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                Color.parseColor("#ff751a"),
                Color.parseColor("#ffd633"))
        );
            gradientDrawable.cornerRadius=70f
            return gradientDrawable;}
        else if(temp.toString().substringBefore(".").toFloat()>=11.0 && temp.toString().substringBefore(".").toFloat()<30.0)
        {   val gradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                Color.parseColor("#c73661"),
                Color.parseColor("#cd6ed4"))
        );
            gradientDrawable.cornerRadius=70f
            return gradientDrawable}
        else
        {val gradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                Color.parseColor("#497DBB"),
                Color.parseColor("#A5C4E9"))
        );
            gradientDrawable.cornerRadius=70f
            return gradientDrawable;}
    }
}
