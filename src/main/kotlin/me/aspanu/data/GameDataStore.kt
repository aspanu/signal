package me.aspanu.data

import me.aspanu.types.Game

object GameDataStore {
    private val dataStore: MutableList<Game> = mutableListOf()
//    private val dataStore: MutableMap<GameId, Game> = mutableMapOf()

    fun initializeNewGame() {
        dataStore.removeLast()
        dataStore.add(
            Game(-1, -1, mutableListOf(), -1)
        )
    }

    fun getGame():Game {
        return dataStore.first()
    }
}