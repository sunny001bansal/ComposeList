package com.example.composerlist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _screenConfigs = MutableStateFlow(screens)
    val screenConfigs: StateFlow<List<ScreenConfig>> = _screenConfigs.asStateFlow()

    fun getScreenConfigById(id: Int): ScreenConfig? =
        _screenConfigs.value.find { it.id == id }
}

