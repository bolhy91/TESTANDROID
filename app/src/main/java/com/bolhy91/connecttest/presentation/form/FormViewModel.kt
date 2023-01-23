package com.bolhy91.connecttest.presentation.form

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bolhy91.connecttest.domain.model.Person
import com.bolhy91.connecttest.domain.repository.FormRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    private val personRepository: FormRepository
) : ViewModel() {

    val saveState = mutableStateOf(false)

    fun saveForm(person: Person) {
        Log.i("TAG PERSON: ", person.toString())
        viewModelScope.launch {
            personRepository.insertPerson(person).collect { result ->
                Log.i("TAG INSERT VIEW MODEL: ", result.toString())
                saveState.value = result
            }
        }
    }
}