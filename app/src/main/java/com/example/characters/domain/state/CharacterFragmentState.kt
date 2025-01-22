package com.example.characters.domain.state

import com.example.characters.data.model.Character


sealed class CharacterFragmentState {
    data class Error(val error: String) : CharacterFragmentState()
    data class SuccessCharacter(val character: List<Character>) : CharacterFragmentState()
    data object LoadingCharacter : CharacterFragmentState()
}