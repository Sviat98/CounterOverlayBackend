package com.bashkevich.counteroverlaybackend.feature.counter

import com.bashkevich.counteroverlaybackend.plugins.dbQuery
import com.bashkevich.counteroverlaybackend.model.counter.CounterEntity
import com.bashkevich.counteroverlaybackend.model.counter.CounterObserver

class CounterRepository {

    suspend fun getCounters(): List<CounterEntity> {
        return dbQuery {
            CounterEntity.all().sortedBy { it.id.value }.toList()
        }
    }

    suspend fun getCounterById(id: Int): CounterEntity? {
        return dbQuery {
            CounterEntity.findById(id)
        }
    }

    suspend fun addCounter(counterName: String, counterValue: Int): CounterEntity {
        return dbQuery {
            CounterEntity.new {
                name = counterName
                value = counterValue
            }
        }
    }

    suspend fun changeCounterValue(counterId: Int, counterDelta: Int): CounterEntity? {
        return dbQuery {
            val counter = CounterEntity.findByIdAndUpdate(counterId) {
                it.value += counterDelta
            }

            counter?.let {
                CounterObserver.notifyChange(it)
            }

            counter
        }
    }
}