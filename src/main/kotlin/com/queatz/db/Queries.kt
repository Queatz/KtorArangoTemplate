package com.queatz.db

/**
 * Queries.kt
 *
 * Put all your AQL in this file.
 *
 * https://www.arangodb.com/docs/stable/aql
 *
 * Usage:
 *
 * Create extension functions on Db here returning a call to one(), list(), or query().
 * The first parameter to all of these is the result type.
 * Optionally, give your function parameters and pass them into the query.
 *
 * One result query:
 *
 * fun Db.person(<specify parameters>) = one(
 *     Person::class, """
 *     for person in @@collection
 *         filter person.${f(Person::<field>)} == @parameter
 *         return person
 *     """, mapOf(
 *         "parameter" to parameter
 *     )
 * )
 *
 * List result query:
 *
 * fun Db.people(<specify parameters>) = list(
 *     Person::class, """
 *     for person in @@collection
 *         filter person.${f(Person::<field>)} == @parameter
 *         return person
 *     """, mapOf(
 *         "parameter" to parameter
 *     )
 * )
 *
 * Custom result query:
 *
 * query(
 *     Int::class, """
 *     return count(`${Person::class.collection}`)
 *     """
 * )
 *
 * Writing queries:
 *
 * Use standard AQL along with the following helpers:
 *
 *  ## @@collection
 *
 *  This is a reference to the collection holding the models of the query type specified.
 *
 *  Example:
 *      for person in @@collection
 *          return person
 *
 *  ## asKey()
 *
 *  Ensures a string is a key.
 *
 *  Example:
 *      val key = idString.asKey()
 *
 *  ## asId(Model::class)
 *
 *  Ensures a string is a database id.
 *
 *  Example:
 *      val id = key.asId()
 *
 *  ## Model::class.collection
 *
 *  Reference a collection name in your query.
 *
 *  Example:
 *      for person in `${Person::class.collection}` return person
 *
 *  ## Model::class.graph
 *
 *  Reference a graph name in your query.
 *
 *  Example:
 *      for vertex, edge, path in any @person graph `${Relationship::class.graph}` return vertex
 *
 *  ## f(Model::<field>)
 *
 *  Reference a model field.
 *
 *  Example:
 *      for person in @@collection
 *          return person.${f(Person::name)}
 *
 *  ## v(<any>)
 *
 *  Serialize a raw value.
 *
 *  Example:
 *      for animal in @@collection
 *          filter animal.${f(Animal::kind)} == ${v(Kind.Dog)}
 *          return animal
 */

/**
 * Returns person with a token.
 */
fun Db.person(token: String) = one(
    Person::class, """
    for person in @@collection
        filter person.${f(Person::token)} == @token
        return person
    """, mapOf(
        "token" to token
    )
)

/**
 * Returns the total number of people.
 */
val Db.countPeople
    get() = query(
        Int::class, """
    return count(`${Person::class.collection}`)
    """
).first()!!
