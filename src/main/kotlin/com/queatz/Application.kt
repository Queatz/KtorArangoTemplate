package com.queatz

import com.queatz.db.Person
import com.queatz.db.person
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.defaultheaders.*
import kotlinx.coroutines.CoroutineScope

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

data class PersonPrincipal(val person: Person) : Principal

fun Application.module() {
    scope = CoroutineScope(coroutineContext)
    install(Compression) {
        gzip {
            priority = 1.0
        }
        deflate {
            priority = 10.0
            minimumSize(1024)
        }
    }
    install(CORS) {
        allowNonSimpleContentTypes = true
        allowMethod(HttpMethod.Options)
        allowHeader(HttpHeaders.Authorization)
        anyHost()
    }
    install(DefaultHeaders)
    install(ContentNegotiation) {
        json()
    }
    install(Authentication) {
        bearer {
            authenticate { bearer ->
                db.person(bearer.token)?.let(::PersonPrincipal)
            }
        }
    }
    routes()
}
