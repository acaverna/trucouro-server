package br.com.trucouro.server.messages

import com.google.gson.annotations.SerializedName

class CreateRoomRequest(
    id: Int,
    type:String,
    val token:String,
    @SerializedName("room-name")
    val roomName:String
):RequestMessage(id, type)