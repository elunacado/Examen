package com.example.examen.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.network.model.DragonBallObject
import com.example.examen.domain.DragonBallListRequirements
import com.example.mypokedexapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllCharactersViewModel : ViewModel() {
    val characters = MutableLiveData<List<DragonBallObject>>()
    private val dragonBallListRequirements = DragonBallListRequirements()

    fun getDragonBallList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result: List<DragonBallObject>? = dragonBallListRequirements(Constants.MAX_CHARACTER_NUMBER)
                result?.let {
                    characters.postValue(it)
                } ?: run {
                    characters.postValue(emptyList())
                }
            } catch (e: Exception) {
                characters.postValue(emptyList())
            }
        }
    }
}