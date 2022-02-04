package com.example.onboarding_presentation.gender

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.Gender
import com.example.core.domain.preferences.Preferences
import com.example.core.navigation.Route
import com.example.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenderViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    var selectedGender by mutableStateOf<Gender>(Gender.Male)
        private set
    //We shouldn't be able to change this from outside

    private val _uiEvent: Channel<UiEvent> = Channel<UiEvent>()
    val uiEvent: Flow<UiEvent> = _uiEvent.receiveAsFlow()

    fun onGenderClick(gender: Gender) {
        selectedGender = gender
    }

    fun onNextClick() {
        //Since sending an event into a channel is a suspending operation
        viewModelScope.launch {
            preferences.saveGender(selectedGender)
            _uiEvent.send(UiEvent.Navigate(Route.AGE))
        }
    }


}