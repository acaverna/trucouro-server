package br.com.trucouro.server.messages

class ListRoomsRequest(
    id:Int,
    type:String,
    val token:String
):RequestMessage(id, type)