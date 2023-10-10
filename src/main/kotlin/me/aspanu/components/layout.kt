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
        id = "body"
        h1 { +"Hello, world!" }
        p { +"This is a paragraph." }
        form {
            hxPost("/game/join")
            hxTarget("#body")
            hxSwap("innerHtml")
            hxPushUrl()
            // TODO: Add validation that the name is submitted here?

            label {
                htmlFor = "name"
                +"Enter player name:"
            }
            input {
                id = "name"
                type = InputType.text
                placeholder = "Enter name..."
                name = "name"
            }
            button {
                +"Start game!"
            }
        }
        button {
            hxGet("/game/hand")
            +"Get the cards for the player"
        }
    }
}