package me.aspanu.components

import kotlinx.html.BODY
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.p
import me.aspanu.data.GameDataStore
import me.aspanu.types.Player

fun BODY.gameLayout(currentPlayer: Player) {
    playerStatus()
    synchronizeButton()
    playerHand(currentPlayer)
}

fun BODY.playerStatus() {
    val game = GameDataStore.getGame()
    div(classes = "box") {
        p(classes = "box-lives") {
            +"Lives: ${game.lives}"
        }
        for (player in game.players) {
            p(classes = "box-players") {
                +"Player: ${player.name} has ${player.cards.size} cards left"
            }
        }
    }
}

fun BODY.synchronizeButton() {
    div {
        button {
            hxPost("/game/synchronize")
            +"Synchronize!"
        }
    }
}