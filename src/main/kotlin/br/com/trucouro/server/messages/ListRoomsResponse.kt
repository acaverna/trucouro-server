package br.com.trucouro.server.messages

import br.com.trucouro.game.Room

class ListRoomsResponse(
    id:Int,
    type:String,
    statusCode:Int,
    val rooms: List<Room>
):ResponseMessage(id, type, statusCode)