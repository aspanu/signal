package me.aspanu.controllers

import me.aspanu.data.GameDataStore
import me.aspanu.types.GameState
import me.aspanu.types.Player

object GameController {

    fun handleGameCreation(name: String): Player {
        // Create a new game if one doesn't exist already, and then populate the first player in it
        println("Got the name: $name")
        val game = GameDataStore.getGame()
        val currentPlayer = if (game.state != GameState.READY) {
            // Means that the previous game needs to be stopped, so let's do that
            GameDataStore.initializeNewGame()
            Player(1, name, mutableSetOf())
        } else {
            val newId = (game.players.size) + 1
            Player(newId, name, mutableSetOf())
        }

        GameDataStore.getGame().players.add(currentPlayer)
        // TODO: figure out how to return html here too
        return currentPlayer
    }

    fun handleStartingARound() {
        // Check to see if all players have clicked on 'ready'
        // If so, shuffle, deal, and then have everyone go to 'synchronize'
        // Keep track of all numbers that were shuffled and thus the number next expected
        if (GameDataStore.getGame().playersReady())
            TODO("Handle the replacement of the screen with the player dialogue, the 'synchronize' button and the hand area")
    }
}