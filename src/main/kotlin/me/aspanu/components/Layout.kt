package me.aspanu.components

import kotlinx.html.*

fun HTML.layout() {
    head {
        title { +"Game Page" }
        script {
            src = "js/htmx.min.js"
        }
    }
    body {
        h1 { +"Hello, world!" }
        p { +"This is a paragraph." }
    }
}