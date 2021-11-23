package com.faskn.app.weatherapp.ui.gps

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

abstract class LocationDetection(context: Context) {
    private val appContext=context.applicationContext
    protected val preferences:SharedPreferences
     get() = PreferenceManager.getDefaultSharedPreferences(appContext)
}