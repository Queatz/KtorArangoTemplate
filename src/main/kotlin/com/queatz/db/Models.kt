@file:OptIn(ExperimentalSerializationApi::class)

package com.queatz.db

import com.arangodb.entity.From
import com.arangodb.entity.Key
import com.arangodb.entity.Rev
import com.arangodb.entity.To
import com.arangodb.internal.DocumentFields
import kotlinx.datetime.Instant
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * Models.kt
 *
 * Put all database models in this file.
 */

@Serializable
data class Person(
    var token: String? = null
) : Model()

/**
 * Base model type. All models should extend this class.
 */
@Serializable
open class Model(
    @Key
    @SerialName("id")
    @JsonNames(DocumentFields.KEY)
    var id: String? = null,
    @Rev
    @SerialName("rev")
    @JsonNames(DocumentFields.REV)
    var rev: String? = null,
    var created: Instant? = null,
    var updated: Instant? = null
)

/**
 * Base edge type. All edges should extend this class.
 */
@Serializable
open class Edge(
    @From
    @SerialName("from")
    @JsonNames(DocumentFields.FROM)
    var from: String? = null,
    @To
    @SerialName("to")
    @JsonNames(DocumentFields.TO)
    var to: String? = null
) : Model()
