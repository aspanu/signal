package me.aspanu.components

import kotlinx.html.BODY
import kotlinx.html.div
import kotlinx.html.p

fun BODY.gameStatus() {
    div {
        p { +"The game is currently running" }
        p { +"There are currently 0 players" }
    }
}

