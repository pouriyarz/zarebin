package com.example.base.behaviour

import androidx.lifecycle.viewModelScope
import com.example.base.BaseViewModel
import com.example.networking.response.HaResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun BaseViewModel.invoke(block: suspend () -> Unit) = viewModelScope.launch(Dispatchers.IO) {
    loading(true)
    block()
}

fun BaseViewModel.switchContext(
    dispatcher: CoroutineDispatcher = Dispatchers.Main,
    block: () -> Unit,
) =
    viewModelScope.launch {
        withContext(dispatcher) {
            block()
        }
    }

fun <T : Any> BaseViewModel.parseResponse(response: HaResponse<T>) {
    loading(false)
    when (response) {
        is HaResponse.Success -> success(response.body)
        is HaResponse.Failed -> response.message?.let { failed(it) }
    }
}