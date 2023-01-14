package com.queatz

import com.queatz.db.Db
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.CoroutineScope

/**
 * App.kt
 *
 * Put your main app state here.
 */

lateinit var scope: CoroutineScope
val json = DefaultJson
val db = Db("db", "db", "db")
