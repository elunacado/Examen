package com.example.examen.framework.views.activities
import android.app.Activity
import android.os.Bundle
import com.example.examen.databinding.ActivityMainBinding

class MainActivity: Activity() {
    private lateinit var binding: ActivityMainBinding
    private val TAG = "Saludos desde MainActivity"
    // onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeBinding()
        binding.onlyText.text = TAG
    }

    // Inicializar el binding
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}