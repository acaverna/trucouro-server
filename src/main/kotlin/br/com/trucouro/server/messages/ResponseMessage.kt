package br.com.trucouro.server.messages

import com.google.gson.annotations.SerializedName

open class ResponseMessage(
    val id:Int,
    val type:String,
    @SerializedName("status-code")
    val statusCode: Int)