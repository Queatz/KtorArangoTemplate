# Readme

Jacob's ultra basic Ktor + Arango setup.

Remember to change the package name!

## Files

See individual files for more info.

### `App.kt`
App state. Change Arango login here. Replace with DI as needed.

### `Application.kt`
Ktor server. Change authentication method here.

### `Routes.kt`
Configure route setup here. Put routes in routes/.

### `db/Collections.kt`
Configure Arango collections here.

### `db/Models.kt`
Put database models here. Create a models/ folder as desired.

### `db/Queries.kt`
Put database queries here. Create a queries/ folder as desired.

## Run

`./gradlew run`

From IntelliJ, run `fun main()` in `Application.kt`.

## Build

`./gradlew shadowJar`
