package com.bashkevich.counteroverlaybackend.model.counter

import io.ktor.server.websocket.DefaultWebSocketServerSession
import java.util.concurrent.ConcurrentHashMap

object CounterConnectionManager {
    private val connections = ConcurrentHashMap<Int, MutableList<DefaultWebSocketServerSession>>()

    fun addConnection(counterId: Int, session: DefaultWebSocketServerSession) {
        connections.compute(counterId) { _, list ->
            (list ?: mutableListOf()).apply { add(session) }
        }
        println("Connection added. There are ${connections.size} active connections for counterId = $counterId")
    }

    fun removeConnection(counterId: Int, session: DefaultWebSocketServerSession) {
        connections[counterId]?.let { list ->
            list.remove(session)
            if (list.isEmpty()) {
                connections.remove(counterId)
            }
        }
        println("Connection removed. There are ${connections.size} active connections for counterId = $counterId")
    }

    fun getFirstConnection(counterId: Int): DefaultWebSocketServerSession? {
        return connections[counterId]?.firstOrNull()
    }
}