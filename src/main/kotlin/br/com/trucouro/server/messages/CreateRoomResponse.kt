package br.com.trucouro.server.messages

import com.google.gson.annotations.SerializedName

class CreateRoomResponse(
    id:Int,
    type:String,
    statusCode:Int,
    val message:String
):ResponseMessage(id, type, statusCode )