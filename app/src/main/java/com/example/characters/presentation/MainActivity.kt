package com.example.characters.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.characters.R
import com.example.characters.databinding.ActivityMainBinding
import com.example.characters.presentation.fragment.CharactersFragment

class MainActivity : AppCompatActivity() {


    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, CharactersFragment())
            .addToBackStack(null)
            .commit()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}