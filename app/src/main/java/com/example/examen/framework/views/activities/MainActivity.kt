package com.example.examen.framework.views.activities
import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.examen.R
import com.example.examen.databinding.ActivityMainBinding
import com.example.examen.framework.views.fragments.AllCharactersFragment
import com.example.examen.framework.views.fragments.ZeroKiFragment
import com.example.mypokedexapp.utils.Constants

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var currentFragment: Fragment
    private var currentMenuOption:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeBinding()
        initializeObservers()
        initializeListeners()
        exchangeCurrentFragment(AllCharactersFragment() , Constants.MENU_DRAGONBALL)
    }

    // Inicializar el binding
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeListeners(){
        binding.appBarMain.llPokedex.setOnClickListener {
            selectMenuOption(Constants.MENU_DRAGONBALL)
        }

        binding.appBarMain.llSearch.setOnClickListener {
            selectMenuOption(Constants.MENU_ZEROKI)
        }
    }

    private fun exchangeCurrentFragment(newFragment: Fragment, newMenuOption:String){
        currentFragment = newFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, newFragment)
            .commit()
        currentMenuOption = newMenuOption
    }

    private fun selectMenuOption(menuOption:String){
        if(menuOption == currentMenuOption){
            return
        }

        when(menuOption){
            Constants.MENU_DRAGONBALL -> exchangeCurrentFragment(AllCharactersFragment(),Constants.MENU_DRAGONBALL)
            Constants.MENU_ZEROKI -> exchangeCurrentFragment(ZeroKiFragment(),Constants.MENU_ZEROKI)
        }
    }

    private fun initializeObservers() {

    }
}