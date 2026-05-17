package com.bashkevich.counteroverlaybackend.model.counter

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object CounterObserver {
    private val counterFlows = mutableMapOf<Int, MutableSharedFlow<CounterDto>>()

    fun getCounterFlow(id: Int): SharedFlow<CounterDto> {
        return counterFlows.getOrPut(id) {
            MutableSharedFlow(replay = 1)
        }.asSharedFlow()
    }

    suspend fun notifyChange(counterDto: CounterDto) {
        val id = counterDto.id.toInt()
        val flow = counterFlows.getOrPut(id) {
            MutableSharedFlow(replay = 1)
        }
        flow.emit(counterDto)
    }
}