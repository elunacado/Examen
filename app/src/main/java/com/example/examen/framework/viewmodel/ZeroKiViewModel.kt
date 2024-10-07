package com.example.examen.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.network.model.DragonBallObject
import com.example.examen.domain.DragonBallListRequirements
import com.example.mypokedexapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ZeroKiViewModel : ViewModel() {
    val zeroKiCharacters = MutableLiveData<List<DragonBallObject>>()
    private val dragonBallListRequirements = DragonBallListRequirements()

    fun getZeroKiList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result: List<DragonBallObject>? = dragonBallListRequirements(Constants.MAX_CHARACTER_NUMBER)
                val zeroKiList = result?.filter { it.ki == "0" } ?: emptyList()
                zeroKiCharacters.postValue(zeroKiList)
            } catch (e: Exception) {
                zeroKiCharacters.postValue(emptyList())
            }
        }
    }
}