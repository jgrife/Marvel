package com.example.marvel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActviityViewModel @Inject constructor(
    private val repository: MarvelRepository
) : ViewModel() {

    var state by mutableStateOf(ComicDetailsState())
        private set

    init {
        viewModelScope.launch {
            when (val result = repository.getComic(100)) {
                is Result.Error -> {
                    // TODO()
                }
                is Result.Success -> {
                    state = state.copy(
                        comic = result.data
                    )
                }
            }
        }
    }
}