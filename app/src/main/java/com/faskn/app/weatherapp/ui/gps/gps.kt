package com.faskn.app.weatherapp.ui.gps

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService

import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import androidx.preference.SwitchPreferenceCompat
import com.faskn.app.weatherapp.R
import com.faskn.app.weatherapp.db.entity.CityEntity
import com.faskn.app.weatherapp.db.entity.CoordEntity
import com.faskn.app.weatherapp.domain.model.City
import com.faskn.app.weatherapp.domain.model.Coord
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class gps: PreferenceFragmentCompat() {
    private val LOCATION_PERMISSION_REQ_CODE = 1000;
    private lateinit var fusedLocationClient: FusedLocationProviderClient

     override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.title = "Settings"
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = null
        val switch: SwitchPreference = findPreference("USE_DEVICE_LOCATION") as SwitchPreference
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.requireActivity())
        // Switch preference change listener
        switch?.setOnPreferenceChangeListener{ preference, newValue ->
            if (newValue == true){
                Toast.makeText(this.activity,"Location access enabled",Toast.LENGTH_LONG).show()
                getCurrentLocation1()
                val coord:Coord=Coord(80.9167,26.85)
                val city:City=City(9176,coord,"Lucknow","IN")
            }else{
                Toast.makeText(this.activity,"Location access disabled",Toast.LENGTH_LONG).show()
            }

            true
        }

    }
    fun getCurrentLocation1() {
        if (this.context?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION)
            } != PackageManager.PERMISSION_GRANTED) {
            // request permission
            ActivityCompat.requestPermissions(
                this.context as Activity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQ_CODE);
            return
        }
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                // getting the last known or current location

                val lat = "${location.latitude}"
                val long = "${location.longitude}"
                Toast.makeText(this.activity, "Latitude:"+lat+" Longitude:"+long,
                    Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this.activity, "Failed on getting current location",
                    Toast.LENGTH_SHORT).show()
            }

    }
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        when (requestCode) {
            LOCATION_PERMISSION_REQ_CODE -> {
                if (grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted
                } else {
                    // permission denied
                    Toast.makeText(this.activity, "You need to grant permission to access location",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



}