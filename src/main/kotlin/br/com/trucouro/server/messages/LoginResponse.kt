package br.com.trucouro.server.messages

class LoginResponse(
    id: Int,
    type: String,
    statusCode: Int,
    val message: String,
    val token: String
): ResponseMessage(id, type, statusCode)
