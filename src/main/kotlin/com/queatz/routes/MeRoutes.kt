package com.queatz.routes

import com.queatz.db
import com.queatz.db.Person
import com.queatz.me
import com.queatz.randomToken
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.meRoutes() {
    authenticate {
        /**
         * Returns the authenticated person
         */
        get("/me") {
            call.respond { me() ?: HttpStatusCode.NotFound }
        }
    }

    /**
     * Creates a new person
     */
    post("/me") {
        call.respond {
            db.insert(Person(token = randomToken()))
        }
    }
}
