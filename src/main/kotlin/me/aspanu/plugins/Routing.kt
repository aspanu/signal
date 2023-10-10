package me.aspanu.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import kotlinx.html.body
import me.aspanu.components.gameLayout
import me.aspanu.components.gameStatus
import me.aspanu.components.layout
import me.aspanu.components.playerHand
import me.aspanu.controllers.GameController
import me.aspanu.data.GameDataStore
import me.aspanu.types.Player

fun Application.configureRouting() {
    routing {
        get("/") {
            GameDataStore.initializeNewGame()
            call.respondHtml(status = HttpStatusCode.OK) {
                layout()
            }
        }

        get("/game") {
            call.respondHtml(status = HttpStatusCode.OK) {
                body { gameStatus() }
            }
        }

        get("/game/hand") {
            call.respondHtml(status = HttpStatusCode.OK) {
                body { playerHand(Player(1, "Alice", mutableSetOf(1, 3, 5))) }
            }
        }

        post("/game/join") {
            val postBody = call.receiveParameters()
            println("PostBody name: $postBody")
            val playerName = postBody["name"].toString()
            val player = GameController.handleGameCreation(playerName)
            call.respondHtml(status = HttpStatusCode.OK) {
                body { gameLayout(player) }
            }
        }

        staticResources("/", "static") {
            default("index.html")
        }

    }
}
