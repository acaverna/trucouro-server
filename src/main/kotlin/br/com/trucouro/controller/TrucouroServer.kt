package br.com.trucouro.controller

import io.micronaut.websocket.WebSocketBroadcaster
import io.micronaut.websocket.WebSocketSession
import io.micronaut.websocket.annotation.OnClose
import io.micronaut.websocket.annotation.OnMessage
import io.micronaut.websocket.annotation.OnOpen
import io.micronaut.websocket.annotation.ServerWebSocket
import org.reactivestreams.Publisher


@ServerWebSocket("/api")
class TrucouroServer(private val broadcaster: WebSocketBroadcaster) {

    @OnOpen
    fun onOpen(session:WebSocketSession):Publisher<String>{
        println("Oie!")
        return session.send("Ola, seja bem vindo!")
    }

    @OnMessage
    fun onMessage(message: String, session:WebSocketSession):Publisher<String>{
        println("$message")
        return session.send("HAHAH")
    }

    @OnClose
    fun onClose(session:WebSocketSession){

    }

}