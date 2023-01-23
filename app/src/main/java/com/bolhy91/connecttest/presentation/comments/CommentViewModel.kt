package com.bolhy91.connecttest.presentation.comments

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bolhy91.connecttest.domain.repository.CommentRepository
import com.bolhy91.connecttest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val commentRepository: CommentRepository
) : ViewModel() {

    private val _state: MutableState<CommentListState> = mutableStateOf(CommentListState())
    val state: State<CommentListState> = _state

    init {
        getComments()
    }

    private fun getComments() {
        viewModelScope.launch {
            commentRepository.getComments().collect { result ->
                Log.i("TAG REMOTE VIEW MODEL ", result.toString())

                when (result) {
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false, error = result.message, comments = emptyList()
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = false)
                    }
                    is Resource.Success -> {
                        result.data?.let {
                            _state.value = _state.value.copy(
                                comments = result.data, isLoading = false, error = null
                            )
                        }
                    }
                }
            }
        }
    }
}