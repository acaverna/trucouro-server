package br.com.trucouro.game

data class Player(
    val id:String,
    val name:String,
    val email:String,
    val password:String,
    val rank:String,
    val score:UInt,
    val token:String,
    val gravatarHash:String
)