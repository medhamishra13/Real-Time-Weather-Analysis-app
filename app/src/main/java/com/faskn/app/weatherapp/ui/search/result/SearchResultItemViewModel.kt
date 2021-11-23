package com.faskn.app.weatherapp.ui.search.result

import androidx.databinding.ObservableField
import com.faskn.app.weatherapp.core.BaseViewModel
import com.faskn.app.weatherapp.db.entity.CitiesForSearchEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchResultItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<CitiesForSearchEntity>()
}
