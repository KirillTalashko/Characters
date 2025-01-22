package com.example.characters.presentation.fragment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.characters.domain.repository.CharacterRepository
import com.example.characters.domain.state.CharacterFragmentState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val repository: CharacterRepository,
    private val noDate: String,
    private val error: String
) : ViewModel() {

    private val _stateCharacter = MutableLiveData<CharacterFragmentState>()
    val stateCharacter: LiveData<CharacterFragmentState>
        get() = _stateCharacter

    private var page = 1
    private var isLoading = false

    init {
        getCharacterData()
    }

    fun getCharacterData() {
        if (!isLoading) {
            isLoading = true
            _stateCharacter.value = CharacterFragmentState.LoadingCharacter
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val response = repository.getCharacterData(page = page)
                    if (response.isSuccessful) {
                        response.body()?.let { body ->
                            val currentList = body.characters.orEmpty()
                            _stateCharacter.postValue(
                                CharacterFragmentState.SuccessCharacter(
                                    currentList
                                )
                            )
                            page++
                        }
                            ?: run { _stateCharacter.postValue(CharacterFragmentState.Error(noDate)) }
                    } else {
                        _stateCharacter.postValue(CharacterFragmentState.Error(error))
                    }
                } catch (e: Exception) {
                    _stateCharacter.postValue(e.localizedMessage?.let { massage ->
                        CharacterFragmentState.Error(massage)
                    })
                } finally {
                    isLoading = false
                }
            }
        }
    }

    fun getStatusLoading() = isLoading

}