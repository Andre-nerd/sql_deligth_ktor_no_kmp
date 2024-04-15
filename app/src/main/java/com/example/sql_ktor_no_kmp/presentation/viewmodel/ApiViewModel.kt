package com.example.sql_ktor_no_kmp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sql_ktor_no_kmp.data.api.ApiService
import com.example.sql_ktor_no_kmp.domain.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApiViewModel(private val api:ApiService):ViewModel() {
    private val _state = MutableStateFlow<State>(State.Init())
    val state:StateFlow<State>
        get() = _state
    init {
        getUserActivity()
    }
    fun getUserActivity(){
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = State.Loading()
            kotlin.runCatching{
                api.getUserActivity()
            }
                .onSuccess { result ->
                    _state.value = State.Success(result.activity)
                }
                .onFailure{
                    _state.value = State.Error(msg = "no info> because error | $it")
                }
        }
    }
}