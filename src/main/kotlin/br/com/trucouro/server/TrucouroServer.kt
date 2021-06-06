package br.com.trucouro.server

import br.com.trucouro.game.Room
import br.com.trucouro.server.messages.*
import com.google.gson.Gson
import io.micronaut.websocket.WebSocketBroadcaster
import io.micronaut.websocket.WebSocketSession
import io.micronaut.websocket.annotation.OnClose
import io.micronaut.websocket.annotation.OnMessage
import io.micronaut.websocket.annotation.OnOpen
import io.micronaut.websocket.annotation.ServerWebSocket
import org.reactivestreams.Publisher
import java.util.*


@ServerWebSocket("/api")
class TrucouroServer(private val broadcaster: WebSocketBroadcaster) {

    private val gson = Gson()

    @OnOpen
    fun onOpen(session:WebSocketSession):Publisher<String>{
        return session.send("Hello")
    }

    @OnMessage
    fun onMessage(message: String, session:WebSocketSession):Publisher<ResponseMessage>{

        val requestMessage = gson.fromJson(message, RequestMessage::class.java)

        val response = when(requestMessage.type){

            "login" -> {
                val loginRequest = gson.fromJson(message, LoginRequest::class.java)

                if(loginRequest.email == "bruno.lopes@unifor.br" && loginRequest.password == "123456"){
                    LoginResponse(1, "login", 200, "Login realizado com sucesso!", "${UUID.randomUUID()}")
                } else {
                    LoginResponse(1, "login", 401, "Erro ao realizar o login", "")
                }
            }

            "create-room" -> {
                val createRoom = gson.fromJson(message, CreateRoomRequest::class.java)

                val room = Room(
                    UUID.randomUUID().toString(),
                    createRoom.roomName, mutableListOf())

                // TODO: Armazenar a sala em um banco de dados

                CreateRoomResponse(
                    createRoom.id,
                    createRoom.type,
                    200,
                    "Sala ${createRoom.roomName} criada com sucesso")
            }

            "list-rooms" -> {
                val listRoomsRequest = gson.fromJson(message, ListRoomsRequest::class.java)

                // TODO: Verificar se o token é válido

                // TODO: Retornar as salas disponíveis

                ListRoomsResponse(
                    listRoomsRequest.id,
                    listRoomsRequest.type,
                    200,
                    listOf(
                        Room(UUID.randomUUID().toString(),
                            "Amiguês da Caverna",
                            mutableListOf())
                    ))

            }

            else -> {
                ResponseMessage(
                    requestMessage.id,
                    requestMessage.type,
                    404)
            }

        }

        return session.send(response)

    }

    @OnClose
    fun onClose(session:WebSocketSession){

    }

}