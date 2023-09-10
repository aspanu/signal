package me.aspanu.components

import kotlinx.html.BODY
import kotlinx.html.div
import me.aspanu.types.Player

fun BODY.playerHand(player: Player) {
    val cards = player.cards
    div { // TODO: add styling to this player
        for (card in cards) {
            div {
                +"$card"
            }
        }
    }
}