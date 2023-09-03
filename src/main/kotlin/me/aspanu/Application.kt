package me.aspanu

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import me.aspanu.plugins.configureRouting

fun main() {
    System.setProperty("io.ktor.development", "true")

    embeddedServer(
        Netty,
        port = 8080,
        host = "127.0.0.1",
        module = Application::module,
        watchPaths = listOf("classes", "resources")
    ).start(wait = true)
}

fun Application.module() {
    configureRouting()
}
