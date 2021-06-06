package br.com.trucouro.server.messages

class LoginRequest(
    id: Int,
    type:String,
    val email:String,
    val password:String): RequestMessage(id, type)