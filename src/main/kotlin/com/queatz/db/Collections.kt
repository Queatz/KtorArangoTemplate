package com.queatz.db

/**
 * Collections.kt
 *
 * Define and configure all database collections here.
 *
 * Usage:
 *
 * collection<Person> {
 *     index(Person::token)
 * }
 *
 * collection<Relationship>(collectionType = CollectionType.EDGES, nodes = listOf(Person::class))
 *
 * collection<Place> {
 *     ensureGeoIndex(listOf(f(Person::token)), GeoIndexOptions())
 * }
 *
 * @see @{ArangoCollection} for all indexing options
 */

fun collections() = listOf(
    collection<Person> {
        index(Person::token)
    }
)
