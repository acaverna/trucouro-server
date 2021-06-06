package br.com.trucouro.game

data class Room(
    val id:String,
    val name:String,
    val players: MutableList<Player>
    )