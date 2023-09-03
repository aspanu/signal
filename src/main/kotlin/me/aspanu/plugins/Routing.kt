package me.aspanu.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.aspanu.components.layout
import me.aspanu.data.GameDataStore

fun Application.configureRouting() {
    routing {
        get("/") {
//            call.respondText("Hello World!")
            call.respondHtml(status = HttpStatusCode.OK) {
                layout()
            }
        }

        post("/game") {
            // TODO: Add some checks here that we are in the correct state
            GameDataStore.initializeNewGame()
            call.respondText("You have created a new game")
        }

        staticResources("/", "static") {
            default("index.html")
        }

    }
}
