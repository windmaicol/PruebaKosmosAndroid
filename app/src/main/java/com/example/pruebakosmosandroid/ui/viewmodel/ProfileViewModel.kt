package com.example.pruebakosmosandroid.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebakosmosandroid.domain.GetAllCharactersUseCase
import com.example.pruebakosmosandroid.domain.model.Characters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    val characters = MutableLiveData<List<Characters>>()
    val isLoading = MutableLiveData<Boolean>()


    fun getAllCharacters() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val charactersUse = getAllCharactersUseCase()
            charactersUse.let {
                characters.value = it
            }
            isLoading.postValue(false)
        }
    }
}