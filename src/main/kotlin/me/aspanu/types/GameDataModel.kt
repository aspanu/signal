package me.aspanu.types

data class Game(var currentNumber: Int, var lives: Int, val players: MutableCollection<Player>, var round: Int)

data class Player(val id: Int, val name: String, val cards: MutableSet<Int>)

//class GameId(val value: Int)