package com.queatz

import org.slf4j.LoggerFactory
import kotlin.random.Random

fun randomToken(length: Int = 36) =
    (0 until length).joinToString("") { Random.nextInt(35).toString(36).let {
        if (Random.nextBoolean()) it.uppercase() else it }
    }

val Any.logger get() = LoggerFactory.getLogger(this::class.java)!!
