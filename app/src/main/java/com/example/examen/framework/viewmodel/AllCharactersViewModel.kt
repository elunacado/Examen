package com.example.examen.framework.viewmodel

import android.util.Log
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
        Log.d("AllCharactersViewModel", "getDragonBallList called")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d("AllCharactersViewModel", "Fetching DragonBall list")
                val result: List<DragonBallObject>? = dragonBallListRequirements(Constants.MAX_CHARACTER_NUMBER)
                result?.let {
                    Log.d("AllCharactersViewModel", "Fetched ${it.size} DragonBall objects")
                    characters.postValue(it)
                } ?: run {
                    Log.d("AllCharactersViewModel", "No DragonBall objects fetched")
                    characters.postValue(emptyList())
                }
            } catch (e: Exception) {
                Log.e("AllCharactersViewModel", "Error fetching DragonBall list", e)
                characters.postValue(emptyList())
            }
        }
    }
}