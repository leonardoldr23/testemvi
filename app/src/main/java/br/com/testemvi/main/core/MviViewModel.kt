package br.com.testemvi.main.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class MviViewModel<Action, Event, State>(initialState: State) : ViewModel() {

    protected val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state

    private val _actions = Channel<Action>(Channel.Factory.BUFFERED)
    val actions = _actions.receiveAsFlow()

    private val _events = Channel<Event>(Channel.Factory.UNLIMITED)
    val events = _events.receiveAsFlow()

    init {
        handleActions()
    }

    fun dispatch(action: Action) {
        viewModelScope.launch {
            _actions.send(action)
        }
    }

    fun emit(event: Event) {
        viewModelScope.launch {
            _events.send(event)
        }
    }

    fun handleActions() {
        viewModelScope.launch {
            _actions.receiveAsFlow().collect { action ->
                on(action)
            }
        }
    }

    protected abstract suspend fun on(action: Action)

}