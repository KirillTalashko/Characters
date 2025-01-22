package com.example.characters.presentation.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.characters.domain.repository.CharacterRepository
import com.example.characters.presentation.fragment.viewModel.CharactersViewModel

class CustomViewModelFactory(
    private val repository: CharacterRepository,
    private val noDate: String,
    private val error: String
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharactersViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CharactersViewModel(repository, noDate, error) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}