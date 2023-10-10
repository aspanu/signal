package me.aspanu.types

data class Game(
    var currentNumber: Int,
    var lives: Int,
    val players: MutableCollection<Player>,
    var round: Int,
    var state: GameState
) {
    fun playersReady(): Boolean {
        return players.all { it.state == PlayerState.READY }
    }
}

data class Player(
    val id: Int,
    val name: String,
    val cards: MutableSet<Int>,
    var state: PlayerState = PlayerState.JOINED
)

enum class GameState {
    READY,
    STARTED,
    FINISHED,
}

enum class PlayerState {
    JOINED,
    READY,
    PLAYING,
}
//class GameId(val value: Int)