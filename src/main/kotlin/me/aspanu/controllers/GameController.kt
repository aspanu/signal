package me.aspanu.controllers

import me.aspanu.data.GameDataStore
import me.aspanu.types.GameState
import me.aspanu.types.Player

object GameController {

    fun handleGameCreation(): Player {
        // Create a new game if one doesn't exist already, and then populate the first player in it
        val game = GameDataStore.getGame()
        val currentPlayer = if (game.state != GameState.READY) {
            // Means that the previous game needs to be stopped, so let's do that
            GameDataStore.initializeNewGame()
            Player(1, "New Player Name", mutableSetOf())
        } else {
            val newId = (game.players.size) + 1
            Player(newId, "Joining Player Name", mutableSetOf())
        }

        GameDataStore.getGame().players.add(currentPlayer)
        return currentPlayer
    }

    fun handleStartingARound() {
        TODO("Handle the replacement of the screen with the player dialogue, the 'synchronize' button and the hand area")
    }
}