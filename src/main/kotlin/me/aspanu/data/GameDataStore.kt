package me.aspanu.data

import me.aspanu.types.Game
import me.aspanu.types.GameState

object GameDataStore {
    private val dataStore: MutableList<Game> = mutableListOf()

    fun initializeNewGame() {
        if (dataStore.size > 0) dataStore.removeLast()
        dataStore.add(
            Game(-1, -1, mutableListOf(), -1, GameState.READY)
        )
    }

    fun getGame(): Game {
        return dataStore.first()
    }
}