@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package krono

import kotlin.js.JsExport

interface Clock {

    fun currentMicrosAsLong(): Long

    fun currentMicrosAsDouble() = currentMicrosAsLong().toDouble()

    fun currentMillisAsLong() = currentMicrosAsLong() / 1_000

    fun currentMillisAsDouble() = currentMillisAsLong().toDouble()

    fun currentSecondsAsLong() = currentMicrosAsLong() / 1_000_000

    fun currentSecondsAsDouble() = currentMicrosAsLong().toDouble() / 1_000_000
}