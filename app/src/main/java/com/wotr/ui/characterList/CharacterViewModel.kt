package com.wotr.ui.characterList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wotr.data.remote.ApiResult
import com.wotr.domain.dto.CharacterDto
import com.wotr.domain.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    val charactersResult: MutableLiveData<List<CharacterDto>> = MutableLiveData()
    val charactersError: MutableLiveData<Unit> = MutableLiveData()

    fun getCharacters() {
        viewModelScope.launch {
            val result = characterRepository.getList();
            when (result) {
                is ApiResult.Success -> charactersResult.postValue(result.data)
                else -> charactersError.postValue(Unit)
            }
        }
    }

}