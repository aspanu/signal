package me.aspanu.components

import kotlinx.html.*

fun HTML.layout() {
    head {
        title { +"Game Page" }
        script {
            src = "js/htmx.min.js"
        }
    }
    body(classes = "body") {
        h1 { +"Hello, world!" }
        p { +"This is a paragraph." }
        button {
            hxPost("/game")
            hxSwap(".body")
            hxPushUrl()
            +"Start game!"
        }
        button {
            hxGet("/game/hand")
            +"Get the cards for the player"
        }
    }
}