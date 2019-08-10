package com.spacexlaunch.app

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.util.toMap

const val SPACEX_WEBHOOK_ENDPOINT = "/spacex-webhook"

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }

    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }

        post(SPACEX_WEBHOOK_ENDPOINT) {
            val app = SpaceXActionsApp()
            val params = call.receiveText()
            val result = app.handleRequest(params, call.request.headers.toMap()).join()
            call.respond(result)
        }
    }
}

